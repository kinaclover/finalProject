package findEat.action.cal;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import findEat.DB.bean.CalendarVO;
import findEat.DB.bean.FoodVO;
import findEat.DB.dao.FoodAdminDAOImpl;
import findEat.DB.dao.IndexCalendarDAOImpl;

@Controller
public class CalendarAction {

	@Autowired
	private FoodAdminDAOImpl foodDAO = null;
	
	@Autowired
	private IndexCalendarDAOImpl indexCalendarDAO = null;
	
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
		
		return "cal/cal";
	}
	
	@RequestMapping(value="calFoodInsert.do", method=RequestMethod.POST)
	public String calFoodInsert(@ModelAttribute("CalendarVO")CalendarVO CalendarVO) throws Exception{
		indexCalendarDAO.InsertMenu(CalendarVO);
		return "cal/cal";
	}
	
	@RequestMapping(value="calFoodSelect.do", method=RequestMethod.GET) // jackson mapper asl lib 추가
	public @ResponseBody String calFoodSelect(@RequestParam("id") String id) throws Exception  {
	    ObjectMapper mapper = new ObjectMapper(); // 반드시 mapper 클래스 import 할것
	 	Map<String, Object> map = new HashMap<String, Object>();
	 	String mapString = null;
	 	// 개인별 저장된 음식 목록
	 	List<CalendarVO> CalVOList = indexCalendarDAO.SelectAll(id);
//	 	List<CalendarVO> CalVOList = indexCalendarDAO.TotalList();
	 	map.put("CalVOList", CalVOList);
//	 	System.out.println(CalVOList);
	 	
	    try {
	        mapString = mapper.writeValueAsString(map);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return mapString;
	}
	
	@ResponseBody
	@RequestMapping(value="calFoodDelete.do", method=RequestMethod.POST)
	public String calFoodDelete(@RequestBody Map<String,Object> data) throws Exception {
		indexCalendarDAO.DeleteMenu(data);
		return "success";
	}
}
