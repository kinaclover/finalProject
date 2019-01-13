package findEat.action.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import findEat.DB.bean.CalendarVO;
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
	 *	- temporary -
	 *	cal insert : 3
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
	
	//Temporary Cal insert
	@RequestMapping("insertCalDB.do")
	public String insertCalDB(HttpServletRequest request) throws Exception {
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
		List<CalendarVO> idList	= foodDAO.IdList();
		
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
		request.setAttribute("idList", idList);
		return "/menu/insertCalDB";
	}
	@RequestMapping("insertCalDBPro.do")
	public String insertCalDBPro(CalendarVO calVO, HttpServletRequest request) throws Exception {
		int check	= foodDAO.InsertCalDB(calVO);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/menu/insertResult";
	}
	@ResponseBody
	@RequestMapping("deleteCalOne.do")
	public String deleteCalOne(@RequestBody CalendarVO calVO) throws Exception {
		int check	= foodDAO.DeleteOne(calVO);
		return String.valueOf(check);
	}
}
