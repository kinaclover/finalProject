package findEat.action.recommand;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import findEat.DB.bean.ImgsVO;
import findEat.DB.bean.MyPositionVO;
import findEat.DB.dao.ImgsDAOImpl;
import findEat.recommand.bean.PlaceInfo;



@Controller
public class RecommandAction {
	//DAO객체 주입
	@Autowired
	private ImgsDAOImpl imgsDAO=null;
	
	//search.jsp로 keyword를 넘겨주는 함수.
	@RequestMapping("search.do")
	public String test(HttpServletRequest request,HttpServletResponse response ,Model model) throws Exception{

		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("keyword")!=null) {
			model.addAttribute("keyword", request.getParameter("keyword"));
		}
		
		return "recommand/search";
	}
	
	//ajax로 넘어노는 키워드와 현재위치정보를 처리, 크롤링을 하는 함수
	@RequestMapping("searchPro.do")
	@ResponseBody
	public Map searchPro(@RequestBody PlaceInfo[] result, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String address_name1= request.getParameter("address_name1"); //시
		String address_name2= request.getParameter("address_name2"); //구
		String address_name3= request.getParameter("address_name3"); //동
		String menu= request.getParameter("menu");
		
		
		ArrayList<String> place_url=new ArrayList<String>(); // 음식점 홈페이지 주소 저장하기 위한 ArrayList
		ArrayList<String> place_name=new ArrayList<String>(); // 음식점 이름 저장하기 위한 ArrayList
		ArrayList<String> place_id=new ArrayList<String>(); //음식점 아이디 저장하기 위한 ArrayList
		HashMap result_map=null; //크롤링 결과를 받을 HashMap
		
		
		//주소, 음식이름, 가게이름을 db에 있는지 없는지 체크한뒤 없으면 크롤링하기 위해 url을 저장한다.		
		for(int i=0; i< result.length; i++) {
		
			String temp=result[i].getPlace_name();
			String id= result[i].getId();
		    int check=imgsDAO.searchKeyword(id.trim()); //음식점 ID가 있는지 DB체크
		  
		    //ID가 없으면 정보들 저장
		    if(check==0) {
		    	place_name.add(result[i].getPlace_name());
		    	place_url.add(result[i].getPlace_url());
		    	place_id.add(result[i].getId());
		    }
		}
		
		//음식점 정보가 DB에 없을경우 크롤링하는 위한 부분
		if(place_url.size()!=0) {
		
		//arraylist --> string 배열로 변환
		String[] temp = new String[place_url.size()]; // string 배열로 url
		String[] temp2 = new String[place_name.size()];// string 배열로 place_name
		String[] temp3= new String[place_id.size()]; // string 배열로 place_id
		temp=place_url.toArray(temp);
		temp2=place_name.toArray(temp2);
		temp3=place_id.toArray(temp3);
		String[] result_imgs=new String[result.length]; //이미지 주소를 저장하는 String 배열
		
		//크롤링 결과 저장
		result_map=SeleniumCrawling(temp);
		String [] sresult_img=(String [])result_map.get("img");
		
		//DB에 넣는작업
		for(int i=0; i<sresult_img.length; i++) {
			inputDB(address_name1.trim(),address_name2.trim(),address_name3.trim(), sresult_img[i].trim(), temp2[i].trim(), menu.trim(), temp3[i].trim());
		}
		
		// 크롤링한 이미지 주소 정보를 가져온다
		for(int i=0; i<result.length; i++) {
			ImgsVO iv=new ImgsVO();
			iv=imgsDAO.selectKeyword(result[i].getId().trim());
			result_imgs[i]=iv.getImg_url().trim();
		}
		result_map.clear();
		result_map.put("img", result_imgs); //결과를 HashMap에 저장
		
		
		//DB에 ID가 있는경우
		}else {
			
			result_map=new HashMap();
			String[] temp3= new String[result.length]; //음식점 ID 정보를 저장하는 String 배열
			for(int i=0; i<result.length; i++) {
				temp3[i]=result[i].getId();
			}
			String[] result_imgs=new String[temp3.length]; //이미지 주소를 저장할 String 배열
			//이미지 주소 저장
			for(int i=0; i<temp3.length; i++) {
				ImgsVO iv=new ImgsVO();
				iv=imgsDAO.selectKeyword(temp3[i].trim());
				result_imgs[i]=iv.getImg_url().trim();
			}
				
			result_map.put("img",result_imgs);
		}
		
		return result_map;
	}
	
	//동적 크롤링을 위한 함수
	public HashMap SeleniumCrawling(String[] place_url){
		RConnection r=null; //R커넥션 객체
		HashMap result_map=new HashMap(); //결과를 받을 HashMap객체
		//이미지 주소를 크롤링 하는 부분
		try {
			r =new RConnection();
			r.setStringEncoding("utf8");
			r.eval("library(RSelenium)");
			r.eval("result_img = list()");
			r.eval("remDr <- remoteDriver(remoteServerAddr='localhost',port=4445,browserName='chrome')");
			r.eval("remDr$open()");
			r.assign("url", place_url);
			r.eval("for( i in 1:length(url)	){"
					+" Sys.sleep(2);"
					+" remDr$navigate(url[i]);"
					+" Sys.sleep(3);"
					+" doms<- remDr$findElements(using = 'css', '.details_present > a > span.bg_present');"
					+" img <- sapply(doms, function(x){x$getElementAttribute('style')});"
					+" if(length(img)==0){" 
					+"  img[[1]] <-'localhost:8080/findEat/images/noimage.png'" + 
					"};"
					+" result_img <- append(result_img, img);}");
			
			r.eval("result_img<-unlist(result_img, use.names=FALSE)");
		
			REXP rx=r.eval("result_img");
			
			String[] imgs=getIMG(rx.asStrings()); //REXP 타입을 String 배열로 변환
			
			result_map.put("img", imgs);
						
			
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(r != null)try {r.close();}catch(Exception s) {}
		}
		return result_map;
		
	}
	//이미지 주소를 추출하는 함수.
	public String[] getIMG(String[] img) {
		int size=img.length;
		String[] result_img=new String[size];
		for(int i=0; i<img.length; i++) {
			int start = img[i].indexOf("img1");
			//이미지가 없는 경우
			if(start==-1) {
				result_img[i]="localhost:8080/findEat/images/noimage.png";
				continue;
			}
			int end=img[i].lastIndexOf("\");");
			String parseText=img[i].substring(start, end);
			result_img[i]=parseText;
			}
		return result_img;
		
	}
	
	//데이터베이스에 크롤링한 결과를 넣는 함수
	public void inputDB(String address_name1, String address_name2, String address_name3, String img_url, String place_name, String menu, String id) throws Exception {
		ImgsVO iv=new ImgsVO();
		iv.setAddress1(address_name1);
		iv.setAddress2(address_name2);
		iv.setAddress3(address_name3);
		iv.setImg_url(img_url);
		iv.setPlace_name(place_name);
		iv.setMenu(menu);
		iv.setId(id);
		imgsDAO.insertIMGS(iv);
	}
	
	//키워드 없이 현재위치정보만으로 음식점 정보를 찾기 위한 함수 (코드내용은 위와 같음)
	@RequestMapping("myPosition.do")
	@ResponseBody
	public Map myPosition(@RequestBody PlaceInfo[] result, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String address_name1= request.getParameter("address_name1");
		String address_name2= request.getParameter("address_name2");
		String address_name3= request.getParameter("address_name3");
	
		
		
		ArrayList<String> place_url=new ArrayList<String>();
		ArrayList<String> place_name=new ArrayList<String>();
		ArrayList<String> place_id=new ArrayList<String>();
		Map result_map=null;
		
		
		//주소, 음식이름, 가게이름을 db에 있는지 없는지 체크한뒤 없으면 크롤링하기 위해 url을 저장한다.		
		for(int i=0; i< result.length; i++) {
		
			String temp=result[i].getPlace_name();
			String id= result[i].getId();
		    int check=imgsDAO.checkMyPosition(id.trim());
		  
		    if(check==0) {
		    	
		    	place_name.add(result[i].getPlace_name());
		    	place_url.add(result[i].getPlace_url());
		    	place_id.add(result[i].getId());
		    }
		}
		if(place_url.size()!=0) {
			
		//arraylist --> string 배열로 변환
		String[] temp = new String[place_url.size()]; // string 배열로 url
		String[] temp2 = new String[place_name.size()];// string 배열로 place_name
		String[] temp3= new String[place_id.size()]; // string 배열로 place_id
		temp=place_url.toArray(temp);
		temp2=place_name.toArray(temp2);
		temp3=place_id.toArray(temp3);
		String[] result_imgs=new String[result.length];
		
		//크롤링 결과 저장
		result_map=SeleniumCrawling(temp);
		String [] result_img=(String [])result_map.get("img");
		
		for(int i=0; i<result_img.length; i++) {
			
			MyPositionVO pvo=new MyPositionVO();
			pvo.setAddress_name1(address_name1.trim());
			pvo.setAddress_name2(address_name2.trim());
			pvo.setAddress_name3(address_name3.trim());
			pvo.setId(temp3[i].trim());
			pvo.setImg_url(result_img[i].trim());
			pvo.setPlace_name(temp2[i].trim());
		
			imgsDAO.insertMyPosition(pvo);
		}
		
		for(int i=0; i<result.length; i++) {
			ImgsVO iv=new ImgsVO();
			iv=imgsDAO.selectKeyword(result[i].getId().trim());
			result_imgs[i]=iv.getImg_url().trim();
		}
		result_map.clear();
		result_map.put("img", result_imgs);
		
		}else {
			String[] temp_id=new String[result.length];
			String[] result_imgs=new String[temp_id.length];
			for(int i=0; i<result.length; i++) {
				temp_id[i]=result[i].getId().trim();
			}
					
			result_map=new HashMap();
			
			for(int i=0; i<temp_id.length; i++) {
				MyPositionVO pvo=null;
				pvo=imgsDAO.selectMyPosition(temp_id[i]);
				result_imgs[i]=pvo.getImg_url();
				
			}
			
			result_map.put("img",result_imgs);
		}
		
		return result_map;
	}
	
	
}
