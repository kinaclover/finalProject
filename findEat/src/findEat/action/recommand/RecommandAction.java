package findEat.action.recommand;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.mybatis.spring.SqlSessionTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import findEat.DB.bean.ImgsVO;
import findEat.DB.dao.ImgsDAOImpl;
import findEat.recommand.bean.PlaceInfo;


@Controller
public class RecommandAction {
	@Autowired
	private ImgsDAOImpl imgsDAO=null;
	
	
	@RequestMapping("search.do")
	public String test(HttpServletRequest request, Model model){
		String listkeyword = request.getParameter("listkeyword");
		System.out.println("server =========>"+listkeyword);
		model.addAttribute("listkeyword", listkeyword);
		
		return "recommand/search";
	}
	
	
	@RequestMapping("searchPro.do")
	@ResponseBody
	public Map searchPro(@RequestBody PlaceInfo[] result, HttpServletRequest request) throws Exception{
		String[] place_url=new String[result.length];
		String keyword= request.getParameter("keyword");
		String pageNum=request.getParameter("pageNum");
		System.out.println("pagenum============="+pageNum);
		System.out.println("keyword============="+keyword);
		int check=imgsDAO.searchKeyword(keyword, pageNum);
		Map result_map=null;
		List<ImgsVO> list=null;
		for(int i=0; i<result.length; i++) {
				place_url[i]=result[i].getPlace_url();		
		}
		
		if(check==0) {
			result_map=SeleniumCrawling(place_url);
			inputDB(pageNum,keyword, result_map, result);
		}else {
			result_map=new HashMap();
			int i=0;
			list=imgsDAO.selectList(keyword,pageNum);
			Iterator<ImgsVO> it=list.iterator();
			String[] imgs=new String[list.size()];
			while(it.hasNext()) {
				imgs[i++]=it.next().getImg_url();
				
			}
			
			result_map.put("img",imgs);
		}
		
		return result_map;
	}
	
	//동적 크롤링을 위한 함수
	public Map SeleniumCrawling(String[] place_url){
		for(String a : place_url) {
			System.out.println("selenium place_url========>"+a);
		}
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
			
			for(String a : rx.asStrings()) {
				System.out.println("크롤링에서 imgs===============>"+a);
			}
			
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
		System.out.println("크기===============>"+size);
		String[] result_img=new String[15];
		for(int i=0; i<img.length; i++) {
			System.out.println("img 내용 ========>"+img[i]);
			int start = img[i].indexOf("img1");
			System.out.println("start indexof"+i+ "=======>"+start);
			if(start==-1) {
				continue;
			}
			int end=img[i].lastIndexOf("\");");
			String parseText=img[i].substring(start, end);
			result_img[i]=parseText;
			}
		return result_img;
		
	}

	public void inputDB(String pageNum,String keyword, Map result, PlaceInfo[] info) throws Exception {
		System.out.println("2222222222222");
		int size= info.length;
		System.out.println("sizezzzzz==>"+size);
		String[] imgs=(String[]) result.get("img");
		for(String a : imgs) {
			System.out.println("inputdb imgs====================>"+a);
		}
		
		for(int i=0; i<size; i++) {
			ImgsVO iv=new ImgsVO();	
			iv.setPageNum(pageNum);
			if(imgs[i]==null) {
				iv.setImg_url("www.belimoseoul.com/data/3/7a9637933db7117ea07390745349a302.jpg");
			}else {
			iv.setImg_url(imgs[i]);
			}
			iv.setKeyword(keyword);
			iv.setPlace_name(info[i].getPlace_name());
			
			System.out.println("getImg_url==="+iv.getImg_url());
			System.out.println("getPlace_name==="+iv.getPlace_name());
			System.out.println("getKeyword==="+iv.getKeyword());
			
			
			imgsDAO.insertIMGS(iv);
		}
		
		
	}
	
	
	
	
}
