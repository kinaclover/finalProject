package findEat.action.recommand;

import java.util.HashMap;
import java.util.Map;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import findEat.recommand.bean.PlaceInfo;


@Controller
public class RecommandAction {
	
	@RequestMapping("search.do")
	public String test(HttpServletRequest request){
		
		return "recommand/search";
	}
	@RequestMapping("asd.do")
	public String asd(HttpServletRequest request){
		
		return "recommand/asd";
	}
	@RequestMapping("qwe.do")
	public String qwe(HttpServletRequest request){
		
		return "recommand/qwe";
	}
	
	@RequestMapping("searchPro.do")
	@ResponseBody
	public Map searchPro(@RequestBody PlaceInfo[] result) throws Exception{
		String[] place_url=new String[result.length];
		for(int i=0; i<result.length; i++) {
				place_url[i]=result[i].getPlace_url();		
		}
		Map result_map=SeleniumCrawling(place_url);
		
		return result_map;
	}
	
	@RequestMapping("asdPro.do")
	@ResponseBody
	public Map asdhPro(@RequestBody PlaceInfo[] result) throws Exception{
		String[] place_url=new String[result.length];
		for(int i=0; i<result.length; i++) {
				place_url[i]=result[i].getPlace_url();		
		}
		Map result_map=SeleniumCrawling(place_url);
		
		return result_map;
	}
	
	//동적 크롤링을 위한 함수
	public Map SeleniumCrawling(String[] place_url){
		RConnection r=null;
		HashMap result_map=new HashMap();
		try {
			r =new RConnection();
			r.setStringEncoding("utf8");
			r.eval("library(RSelenium)");
			//r.assign("url", place_url);
			r.eval("url <- c('http://place.map.daum.net/27109236', 'http://place.map.daum.net/12315507')");
			r.eval("result_menu = list()");
			r.eval("result_score =list()");
			r.eval("result_review = list()");
			r.eval("result_img = list()");
			r.eval("remDr <- remoteDriver(remoteServerAddr='localhost',port=4445,browserName='chrome')");
			r.eval("remDr$open() ");
			r.eval("for( i in 1:length(url)){"
					+ " Sys.sleep(2);"
					+ " remDr$navigate(url[i]);"
					+ " Sys.sleep(3);"
					+ " doms <- remDr$findElements(using = 'css', '.cont_menu > ul > li > div > span, .place_details > div > h2');"
					+ " doms2 <- remDr$findElements(using = 'css', 'a:nth-child(3) > span.color_b');"
					+ " doms3 <- remDr$findElements(using = 'css', '.review_story > strong, .review_story > p');"
					+ " doms4 <- remDr$findElements(using = 'css', '.review_thumb.exist_img > span.item_photo');"
					+ " menu <- sapply(doms, function (x) {x$getElementText()});"
					+ " score <- sapply(doms2, function (x) {x$getElementText()});"
					+ " review <- sapply(doms3, function (x) {x$getElementText()});"
					+ " img <- sapply(doms4, function(x){x$getElementAttribute('style')});"
					+ " result_menu<-append(result_menu,menu);"
					+ " result_menu<-append(result_menu, '***************************');"
					+ " result_score<-append(result_score,score);"
					+ "	result_score<-append(result_score,'**************************');"
					+ " result_review <- append(result_review, review);"
					+ " result_review <- append(result_review, '**************************');"
					+ " result_img <- append(result_img, img);"
					+ " result_img <- append(result_img, '**************************');}");
			
			r.eval("result_menu <- gsub(' ','', result_menu)");
			r.eval("result_menu <- gsub('\t','', result_menu)");
			r.eval("result_menu <- gsub('\r\n','', result_menu)");
			r.eval("result_menu <- result_menu[c(result_menu!='')]");
			
			r.eval("result_score <- gsub(' ','', result_score)");
			r.eval("result_score <- gsub('\t','', result_score)");
			r.eval("result_score <- gsub('\r\n','', result_score)");
			r.eval("result_score <- result_score[c(result_score!='')]");
			r.eval("result_img<-unlist(result_img, use.names=FALSE)");
			r.eval("result_review<-unlist(result_review, use.names=FALSE)");
			
			
			REXP rx=r.eval("result_menu");
			REXP rxs=r.eval("result_score");
			REXP rxr=r.eval("result_review");
			REXP rxi=r.eval("result_img");
			String[] result_menu=rx.asStrings();
			String[] result_score=rxs.asStrings();
			String[] result_review=rxr.asStrings();
			String[] result_img=rxi.asStrings();
			result_img=getIMG(result_img);
			result_map.put("menu", result_menu);
			result_map.put("score", result_score);
			result_map.put("review", result_review);
			result_map.put("img", result_img);
			
			
			
//			for(String s: result_menu) {
//					System.out.println(s);
//				}
//			System.out.println("스코어");
//			for(String s: result_score) {
//				System.out.println(s);
//			}
//			for(String s: result_review) {
//				System.out.println(s);
//			}
//			for(String s: result_img) {
//				System.out.println(s);
//			}
			
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
		String[] result_img=new String[size];
		for(int i=0; i<img.length; i++) {
			if(img[i].equals("**************************")) {
				result_img[i]="**************************";
				continue;
			}
			int start = img[i].indexOf("img1");
			int end=img[i].indexOf("\");");
			String parseText=img[i].substring(start, end);
			result_img[i]=parseText;
			
		}
		return result_img;
		
	}

	
	
}
