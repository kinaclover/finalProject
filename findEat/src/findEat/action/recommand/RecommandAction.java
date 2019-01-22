package findEat.action.recommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

import javax.servlet.http.HttpServletRequest;

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
	@Autowired
	private ImgsDAOImpl imgsDAO=null;
	
	
	@RequestMapping("search.do")
	public String test(HttpServletRequest request, Model model){
		if(request.getParameter("keyword")!=null) {
			System.out.println("keyword! : "+request.getParameter("keyword"));
			model.addAttribute("keyword", request.getParameter("keyword"));
		}
		
		return "recommand/search";
	}
	
	
	@RequestMapping("searchPro.do")
	@ResponseBody
	public Map searchPro(@RequestBody PlaceInfo[] result, HttpServletRequest request) throws Exception{
		
		String address_name1= request.getParameter("address_name1");
		System.out.println("address_name1=="+address_name1);
		String address_name2= request.getParameter("address_name2");
		System.out.println("address_name2=="+address_name2);
		String address_name3= request.getParameter("address_name3");
		System.out.println("address_name3=="+address_name3);
		String menu= request.getParameter("menu");
		System.out.println("menu=="+menu);
		
		
		ArrayList<String> place_url=new ArrayList<String>();
		ArrayList<String> place_name=new ArrayList<String>();
		ArrayList<String> place_id=new ArrayList<String>();
		HashMap result_map=null;
		
		
		//주소, 음식이름, 가게이름을 db에 있는지 없는지 체크한뒤 없으면 크롤링하기 위해 url을 저장한다.		
		for(int i=0; i< result.length; i++) {
		
			String temp=result[i].getPlace_name();
			String id= result[i].getId();
		    int check=imgsDAO.searchKeyword(id.trim());
		  
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
		for(String a: temp) {
			System.out.println("place_url==========>"+a);
		}
		//크롤링 결과 저장
		result_map=SeleniumCrawling(temp);
		String [] sresult_img=(String [])result_map.get("img");
		for(String a : sresult_img) {
			System.out.println("result_img======="+ a);
		}
		for(int i=0; i<sresult_img.length; i++) {
			System.out.println("address_name1==="+address_name1.trim());
			System.out.println("address_name2==="+address_name2.trim());
			System.out.println("address_name3==="+address_name3.trim());
			System.out.println("result_img==="+sresult_img[i].trim());
			System.out.println("temp2==="+temp2[i].trim());
			System.out.println("menu==="+menu.trim());
			System.out.println("temp3==="+temp3[i].trim());
			inputDB(address_name1.trim(),address_name2.trim(),address_name3.trim(), sresult_img[i].trim(), temp2[i].trim(), menu.trim(), temp3[i].trim());
		}
		
		for(int i=0; i<result.length; i++) {
			ImgsVO iv=new ImgsVO();
			iv=imgsDAO.selectKeyword(result[i].getId().trim());
			result_imgs[i]=iv.getImg_url().trim();
		}
		result_map.clear();
		result_map.put("img", result_imgs);
		
		
		
		}else {
			result_map=new HashMap();
			String[] temp3= new String[result.length];
			for(int i=0; i<result.length; i++) {
				temp3[i]=result[i].getId();
			}
			String[] result_imgs=new String[temp3.length];
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
		System.out.println("place_url==========>"+place_url.length);
		RConnection r=null;
		HashMap result_map=new HashMap();
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
			for(String a : rx.asStrings()) {
				System.out.println("imgs=============>"+a);
			}
			String[] imgs=getIMG(rx.asStrings());
			
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
	@RequestMapping("myPosition.do")
	@ResponseBody
	public Map myPosition(@RequestBody PlaceInfo[] result, HttpServletRequest request) throws Exception{
		
		String address_name1= request.getParameter("address_name1");
		System.out.println("address_name1=="+address_name1);
		String address_name2= request.getParameter("address_name2");
		System.out.println("address_name2=="+address_name2);
		String address_name3= request.getParameter("address_name3");
		System.out.println("address_name3=="+address_name3);
	
		
		
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
		System.out.println("place_url size==================="+place_url.size());
		if(place_url.size()!=0) {
			
		//arraylist --> string 배열로 변환
		String[] temp = new String[place_url.size()]; // string 배열로 url
		String[] temp2 = new String[place_name.size()];// string 배열로 place_name
		String[] temp3= new String[place_id.size()]; // string 배열로 place_id
		temp=place_url.toArray(temp);
		temp2=place_name.toArray(temp2);
		temp3=place_id.toArray(temp3);
		String[] result_imgs=new String[result.length];
		for(String a: temp) {
			System.out.println("place_url==========>"+a);
		}
		//크롤링 결과 저장
		result_map=SeleniumCrawling(temp);
		String [] result_img=(String [])result_map.get("img");
		for(String a : result_img) {
			System.out.println("result_img======="+ a);
		}
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
			System.out.println("temp3 result_imgs ======="+temp_id.length);
			for(String a : temp_id) {
				System.out.println("myposition id===========>"+a);
			}
			for(int i=0; i<temp_id.length; i++) {
				MyPositionVO pvo=null;
				pvo=imgsDAO.selectMyPosition(temp_id[i]);
				result_imgs[i]=pvo.getImg_url();
				
			}
			for(String a : result_imgs) {
				System.out.println("myposition result_imgs===>"+a);
			}
			
			result_map.put("img",result_imgs);
		}
		
		return result_map;
	}
	
	
}
