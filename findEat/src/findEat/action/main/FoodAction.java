package findEat.action.main;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.FoodVO;
import findEat.DB.dao.FoodAdminDAOImpl;
import findEat.action.cal.CalendarSort;

@Controller
public class FoodAction {

	/***********************************************************************************************************************/
	/*
	 * 	*** 관리자전용 음식DB 관리페이지
	 * 
	 * 	Administrator Food insert/delete Action
	 * 	- 관리자 전용 음식 카테고리 관리 페이지
	 * 	- 각 로직 수행 후 status값과 함께 status페이지로 이동
	 * 
	 *	status value
	 *	- insert : 1
	 *	- delete : 2 
	 *
	/***********************************************************************************************************************/
	
	@Autowired
	private FoodAdminDAOImpl foodDAO = null;
	
	//내림차순 정렬을 위한 함수
	private CalendarSort comp = null;
	
	//페이지 로드
	@RequestMapping("insertFood.do")
	public String insertFood(@ModelAttribute("foodVO")FoodVO foodVO, HttpServletRequest request) throws Exception{
		//카테고리별 총 음식의 수
		int kTotal	= (int)foodDAO.CheckTotal("k");
		int jTotal	= (int)foodDAO.CheckTotal("j");
		int cTotal	= (int)foodDAO.CheckTotal("c");
		int wTotal	= (int)foodDAO.CheckTotal("w");
		int fTotal	= (int)foodDAO.CheckTotal("f");
		int eTotal	= (int)foodDAO.CheckTotal("e");
		//카테고리별 음식 리스트
		List<FoodVO> kGroup	= foodDAO.CheckGroup("k");
		List<FoodVO> jGroup	= foodDAO.CheckGroup("j");
		List<FoodVO> cGroup	= foodDAO.CheckGroup("c");
		List<FoodVO> wGroup	= foodDAO.CheckGroup("w");
		List<FoodVO> fGroup	= foodDAO.CheckGroup("f");
		List<FoodVO> eGroup	= foodDAO.CheckGroup("e");
		
		//fcount 값을 기준으로 내림차순 정렬(desc)
		comp	= new CalendarSort();
		Collections.sort(kGroup, comp);
		Collections.sort(jGroup, comp);
		Collections.sort(cGroup, comp);
		Collections.sort(wGroup, comp);
		Collections.sort(fGroup, comp);
		Collections.sort(eGroup, comp);
		
		request.setAttribute("kTotal", kTotal);
		request.setAttribute("jTotal", jTotal);
		request.setAttribute("cTotal", cTotal);
		request.setAttribute("wTotal", wTotal);
		request.setAttribute("fTotal", fTotal);
		request.setAttribute("eTotal", eTotal);
		request.setAttribute("kGroup", kGroup);
		request.setAttribute("jGroup", jGroup);
		request.setAttribute("cGroup", cGroup);
		request.setAttribute("wGroup", wGroup);
		request.setAttribute("fGroup", fGroup);
		request.setAttribute("eGroup", eGroup);
		return "/menu/insertFood";
	}
	
	//음식 정보 입력
	@RequestMapping("insertFoodPro.do")
	public String insertFoodPro(FoodVO foodVO, HttpServletRequest request) throws Exception{
		int check	= (int)foodDAO.InsertFood(foodVO);
		int status	= 1;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/menu/insertResult";
	}
	//음식 정보 삭제
	@RequestMapping("deleteFoodPro.do")
	public String deleteFoodPro(FoodVO foodVO, HttpServletRequest request) throws Exception{
		int check	= (int)foodDAO.DeleteFood(foodVO);
		int status	= 2;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/menu/insertResult";
	}
	
}
