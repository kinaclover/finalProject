package findEat.action.cal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import findEat.DB.bean.CalendarVO;
import findEat.DB.bean.FoodVO;
import findEat.DB.dao.FoodAdminDAOImpl;
import findEat.DB.dao.IndexCalendarDAOImpl;

@Controller
public class CalendarAction {

	@Autowired
	private FoodAdminDAOImpl foodDAO = null;
	
	@Autowired
	private IndexCalendarDAOImpl indexCalDAO = null;
	
	@RequestMapping("cal.do")
	public String calendar (@ModelAttribute("foodVO")FoodVO foodVO, HttpServletRequest request) throws Exception{
		// 음식 그룹 설정
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
		// 음식 그룹 설정
		List<CalendarVO> CalVOList = indexCalDAO.SelectAll("admin");
	 	String cal = CalVOList.get(0).getId();
	 	System.out.println(cal);
	 //	request.setAttribute("CalVOList", CalVOList);
		
		return "cal/cal";
	}
	
	@RequestMapping(value="calFoodInsert.do", method=RequestMethod.POST)
	public String calFoodInsert(@ModelAttribute("indexCalVO")CalendarVO indexCalVO) throws Exception{
		indexCalDAO.insertMenu(indexCalVO);
//		System.out.println(indexCalVO.getFyear());
//		System.out.println(indexCalVO.getFmonth());
//		System.out.println(indexCalVO.getFdate());
//		System.out.println(indexCalVO.getFday());
//		System.out.println(indexCalVO.getFweek());
//		System.out.println(indexCalVO.getFname());
//		System.out.println(indexCalVO.getFcode());
//		System.out.println(indexCalVO.getId());
//		System.out.println(indexCalVO.getClassify());
		
		return "cal/cal";
	}
	

}
