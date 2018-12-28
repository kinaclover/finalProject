package findEat.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.FoodVO;
import findEat.DB.dao.FoodAdminDAOImpl;

@Controller
public class FoodAction {
	
	@Autowired
	private FoodAdminDAOImpl foodDAO = null;
	
	/*
	 *	-status-
	 *	insert : 1
	 *	delete : 2 
	 *
	 */
	//insert foods
	@RequestMapping("insertFood.do")
	public String insertFood(@ModelAttribute("foodVO")FoodVO foodVO, HttpServletRequest request) throws Exception{
		int kTotal	= (int)foodDAO.CheckTotal("k");
		int jTotal	= (int)foodDAO.CheckTotal("j");
		int cTotal	= (int)foodDAO.CheckTotal("c");
		int wTotal	= (int)foodDAO.CheckTotal("w");
		int fTotal	= (int)foodDAO.CheckTotal("f");
		int eTotal	= (int)foodDAO.CheckTotal("e");
		List<FoodVO> kGroup	= foodDAO.CheckGroup("k");
		List<FoodVO> jGroup	= foodDAO.CheckGroup("j");
		List<FoodVO> cGroup	= foodDAO.CheckGroup("c");
		List<FoodVO> wGroup	= foodDAO.CheckGroup("w");
		List<FoodVO> fGroup	= foodDAO.CheckGroup("f");
		List<FoodVO> eGroup	= foodDAO.CheckGroup("e");
		
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
	@RequestMapping("insertFoodPro.do")
	public String insertFoodPro(FoodVO foodVO, HttpServletRequest request) throws Exception{
		int check	= (int)foodDAO.InsertFood(foodVO);
		int status	= 1;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/menu/insertResult";
	}
	
	@RequestMapping("deleteFoodPro.do")
	public String deleteFoodPro(FoodVO foodVO, HttpServletRequest request) throws Exception{
		int check	= (int)foodDAO.DeleteFood(foodVO);
		int status	= 2;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/menu/insertResult";
	}
	
	/*
	 * 	- restaurant -
	 */
	@RequestMapping("restaurant.do")
	public String restaurant(HttpServletRequest request) throws Exception {
		
		List<FoodVO> kGroup	= foodDAO.CheckGroup("k");
		List<FoodVO> jGroup	= foodDAO.CheckGroup("j");
		List<FoodVO> cGroup	= foodDAO.CheckGroup("c");
		List<FoodVO> wGroup	= foodDAO.CheckGroup("w");
		List<FoodVO> fGroup	= foodDAO.CheckGroup("f");
		List<FoodVO> eGroup	= foodDAO.CheckGroup("e");
		request.setAttribute("kGroup", kGroup);
		request.setAttribute("jGroup", jGroup);
		request.setAttribute("cGroup", cGroup);
		request.setAttribute("wGroup", wGroup);
		request.setAttribute("fGroup", fGroup);
		request.setAttribute("eGroup", eGroup);
		
		return "/menu/insertRestaurant";
	}
}
