package findEat.action.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import findEat.DB.bean.CalendarVO;
import findEat.DB.bean.FoodVO;
import findEat.DB.dao.FoodAdminDAOImpl;

@Controller
public class CalDBAction {

	@Autowired
	private FoodAdminDAOImpl foodDAO = null;
	
	@Autowired
	private CalendarVO calVO = null;
	
	/*
	 * 	- calDB status
	 * 	cal insert : 3
	 * 	cal delete : 4
	 */

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
		List<CalendarVO> calTotalList	= foodDAO.CalTotalList();
		List<String> idList	= new ArrayList<>();
		int count = 0;
		
		//중복id 제거
		for(CalendarVO temp: calTotalList) {
			if(idList.isEmpty()) idList.add(temp.getId());
			else {
				for(String x: idList) {
					if(x.equals(temp.getId())) count++;
				}
				if(count == 0) {
					idList.add(temp.getId());
				}
				count = 0;
			}
		}
		Collections.sort(idList);		//sort
		request.setAttribute("idList", idList);
		
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
		request.setAttribute("calTotalList", calTotalList);
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
	
	/* check fname */
	@ResponseBody
	@RequestMapping("checkFname.do")
	public String checkFname(@RequestBody Map<String,Object> data) throws Exception {
		calVO.setId((String)data.get("id"));
		calVO.setFyear((int)data.get("fyear"));
		calVO.setFmonth((int)data.get("fmonth"));
		calVO.setFdate((int)data.get("fdate"));
		String fname = foodDAO.SelectFname(calVO);
		return String.valueOf(fname);
	}
	
	@RequestMapping("deleteCalOne.do")
	public String deleteCalOne(HttpServletRequest request) throws Exception {
		calVO.setId(request.getParameter("id"));
		calVO.setFyear(Integer.parseInt(request.getParameter("fyear")));
		calVO.setFmonth(Integer.parseInt(request.getParameter("fmonth")));
		calVO.setFdate(Integer.parseInt(request.getParameter("fdate")));
		int check	= foodDAO.DeleteOne(calVO);
		int status	= 4;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/menu/insertResult";
	}
}
