package findEat.action.recommand;

import java.util.ArrayList;
import java.util.HashMap;
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
		String menu=request.getParameter("menu");
		model.addAttribute("menu", menu);
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
		
		String address_name2= request.getParameter("address_name2");
		
		String address_name3= request.getParameter("address_name3");
		
		String menu= request.getParameter("menu");
		
		
		
		ArrayList<String> place_url=new ArrayList<String>();
		ArrayList<String> place_name=new ArrayList<String>();
		Map result_map=null;
		ArrayList<String> result_imgs=new ArrayList<String>();
		
		//주소, 음식이름, 가게이름을 db에 있는지 없는지 체크한뒤 없으면 크롤링하기 위해 url을 저장한다.		
		for(int i=0; i< result.length; i++) {
		
			String temp=result[i].getPlace_name();
		    int check=imgsDAO.searchKeyword(address_name1.trim(), address_name2.trim(), address_name3.trim(), menu.trim(), temp.trim());
		  
		    if(check==0) {
		    	
		    	place_name.add(result[i].getPlace_name());
		    	place_url.add(result[i].getPlace_url());
		    }
		}
		
		if(place_url.size()!=0) {
			
		//arraylist --> string 배열로 변환
		String[] temp = new String[place_url.size()]; // string 배열로 url
		String[] temp2 = new String[place_name.size()];// string 배열로 place_name
		temp=place_url.toArray(temp);
		temp2=place_name.toArray(temp2);
			
		//크롤링 결과 저장
		result_map=SeleniumCrawling(temp);
		String [] result_img=(String [])result_map.get("img");
		
		for(int i=0; i<result_img.length; i++) {
			if(result_img[i]==null) {
				result_img[i]="www.belimoseoul.com/data/3/7a9637933db7117ea07390745349a302.jpg";
			}
		}
			
		
		for(int i=0; i<result_img.length; i++) {
		inputDB(address_name1.trim(),address_name2.trim(),address_name3.trim(), result_img[i].trim(), temp2[i].trim(), menu.trim());
		}
		
		}else {
			result_map=new HashMap();
			String[] t_place_name=new String[result.length];
			for(int i=0; i<t_place_name.length; i++) {
				t_place_name[i]=result[i].getPlace_name();
			}
			
			for(int i=0; i<t_place_name.length; i++) {
				ImgsVO iv=new ImgsVO();
				iv=imgsDAO.selectVO(address_name1.trim(),address_name2.trim(),address_name3.trim(),menu.trim(),t_place_name[i].trim());
				result_imgs.add(iv.getImg_url());
			}
			String[] imgs=new String[result_imgs.size()];
			imgs=result_imgs.toArray(imgs);
			
			result_map.put("img",imgs);
		}
		
		return result_map;
	}
	
	//동적 크롤링을 위한 함수
	public Map SeleniumCrawling(String[] place_url){
		
		RConnection r=null;
		Map result_map=new HashMap();
		try {
			r =new RConnection();
			r.setStringEncoding("utf8");
			r.eval("library(RSelenium)");
			r.eval("result_img = list()");
			r.eval("remDr <- remoteDriver(remoteServerAddr='localhost',port=4445,browserName='chrome')");
			r.eval("remDr$open()");
			r.assign("url", place_url);
			r.eval("for( i in 1:length(url)){"
					+" Sys.sleep(2);"
					+" remDr$navigate(url[i]);"
					+" Sys.sleep(3);"
					+" doms<- remDr$findElements(using = 'css', '.details_present > a > span.bg_present');"
					+" img <- sapply(doms, function(x){x$getElementAttribute('style')});"
					+" if(length(img)==0){" + 
					"  img[[1]] <-'http://www.belimoseoul.com/data/3/7a9637933db7117ea07390745349a302.jpg'" + 
					"};"
					+" result_img <- append(result_img, img);}");
			
			r.eval("result_img<-unlist(result_img, use.names=FALSE)");
		
			REXP rx=r.eval("result_img");
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
				continue;
			}
			int end=img[i].lastIndexOf("\");");
			String parseText=img[i].substring(start, end);
			result_img[i]=parseText;
			}
		return result_img;
		
	}

	public void inputDB(String address_name1, String address_name2, String address_name3, String img_url, String place_name, String menu) throws Exception {
		ImgsVO iv=new ImgsVO();
		
		iv.setAddress1(address_name1);
		iv.setAddress2(address_name2);
		iv.setAddress3(address_name3);
		iv.setImg_url(img_url);
		iv.setPlace_name(place_name);
		iv.setMenu(menu);
				
		imgsDAO.insertIMGS(iv);
	}
	@RequestMapping("myPosition.do")
	@ResponseBody
	public Map myPosition(@RequestBody PlaceInfo[] result, HttpServletRequest request) throws Exception{
		
		String address_name1= request.getParameter("address_name1");
		String address_name2= request.getParameter("address_name2");
		String address_name3= request.getParameter("address_name3");
				
		ArrayList<String> place_url=new ArrayList<String>();
		ArrayList<String> place_name=new ArrayList<String>();
		Map result_map=null;
		ArrayList<String> result_imgs=new ArrayList<String>();
		
		//주소, 음식이름, 가게이름을 db에 있는지 없는지 체크한뒤 없으면 크롤링하기 위해 url을 저장한다.		
		for(int i=0; i< result.length; i++) {
			String temp=result[i].getPlace_name();
		    int check=imgsDAO.checkMyPosition(address_name1.trim(), address_name2.trim(), address_name3.trim(), temp.trim());
		    if(check==0) {
		    	place_name.add(result[i].getPlace_name());
		    	place_url.add(result[i].getPlace_url());
		    }
		}
		
		if(place_url.size()!=0) {
		//arraylist --> string 배열로 변환
		String[] temp = new String[place_url.size()]; // string 배열로 url
		String[] temp2 = new String[place_name.size()];// string 배열로 place_name
		temp=place_url.toArray(temp);
		temp2=place_name.toArray(temp2);
		
		//크롤링 결과 저장
		result_map=SeleniumCrawling(temp);
		String [] result_img=(String [])result_map.get("img");
		
		for(int i=0; i<result_img.length; i++) {
			if(result_img[i]==null) {
				result_img[i]="www.belimoseoul.com/data/3/7a9637933db7117ea07390745349a302.jpg";
			}
		}
			
		
		for(int i=0; i<result_img.length; i++) {
			MyPositionVO pvo=new MyPositionVO();
			pvo.setImg_url(result_img[i]);
			pvo.setAddress_name1(address_name1);
			pvo.setAddress_name2(address_name2);
			pvo.setAddress_name3(address_name3);
			pvo.setPlace_name(temp2[i]);
			imgsDAO.insertMyPosition(pvo);
		}
		
		}else {
			
			result_map=new HashMap();
			String[] t_place_name=new String[result.length];
			for(int i=0; i<t_place_name.length; i++) {
				t_place_name[i]=result[i].getPlace_name();
			}
			for(int i=0; i<t_place_name.length; i++) {
				MyPositionVO vo= new MyPositionVO();
				vo=imgsDAO.getPostionVO(address_name1, address_name2, address_name3, t_place_name[i]);
				result_imgs.add(vo.getImg_url());
			}
			String[] imgs=new String[result_imgs.size()];
			imgs=result_imgs.toArray(imgs);
			
			result_map.put("img",imgs);
		}
		
		return result_map;
	}
	
	
}
