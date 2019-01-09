package findEat.action.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.CalendarVO;
import findEat.DB.dao.CalendarDAOImpl;

@Controller
public class SuggestAction {
	
	private List<CalendarVO> totalclassify		= null;	
	private Map<String,Integer> totalclassifyk	= null;
	private Map<String,Integer> totalclassifyj	= null;
	private Map<String,Integer> totalclassifyc	= null;
	private Map<String,Integer> totalclassifyw	= null;
	private Map<String,Integer> totalclassifyf	= null;
	private Map<String,Integer> totalclassifye	= null;
	
	private List<CalendarVO> personalclassify		= null;
	private Map<String,Integer> personalclassifyk	= null;
	private Map<String,Integer> personalclassifyj	= null;
	private Map<String,Integer> personalclassifyc	= null;
	private Map<String,Integer> personalclassifyw	= null;
	private Map<String,Integer> personalclassifyf	= null;
	private Map<String,Integer> personalclassifye	= null;
	
	private MapSort sort	= new MapSort();						//map 정렬을 위한 함수
	
	private Calendar cal	= new GregorianCalendar();
	
	@Autowired
	private CalendarDAOImpl calDAO	= null;

	@RequestMapping("suggestion.do")
	public String suggest(HttpServletRequest request) throws Exception {
		//
		int count	= 0;
		int week	= cal.get(Calendar.WEEK_OF_YEAR);
		
		//recommand K total
		totalclassify = calDAO.Classifyk(week);
		totalclassifyk	= new HashMap<>();
		
		
		for(CalendarVO temp: totalclassify) {
		if(totalclassifyk.isEmpty()) totalclassifyk.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :totalclassifyk.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) totalclassifyk.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		totalclassifyk = sort.Sorting(totalclassifyk);
		request.setAttribute("totalclassifyk", totalclassifyk);
		
		//recommand J total
		totalclassify = calDAO.Classifyj(week);
		totalclassifyj	= new HashMap<>();

		for(CalendarVO temp: totalclassify) {
		if(totalclassifyj.isEmpty()) totalclassifyj.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :totalclassifyj.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) totalclassifyj.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		totalclassifyj = sort.Sorting(totalclassifyj);
		request.setAttribute("totalclassifyj", totalclassifyj);
		
		//recommand C total
		totalclassify = calDAO.Classifyc(week);
		totalclassifyc	= new HashMap<>();
		

		for(CalendarVO temp: totalclassify) {
		if(totalclassifyc.isEmpty()) totalclassifyc.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :totalclassifyc.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) totalclassifyc.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		totalclassifyc = sort.Sorting(totalclassifyc);
		request.setAttribute("totalclassifyc", totalclassifyc);
		
		//recommand W total
		totalclassify = calDAO.Classifyw(week);
		totalclassifyw	= new HashMap<>();
		

		for(CalendarVO temp: totalclassify) {
		if(totalclassifyw.isEmpty()) totalclassifyw.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :totalclassifyw.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) totalclassifyw.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		totalclassifyw = sort.Sorting(totalclassifyw);
		request.setAttribute("totalclassifyw", totalclassifyw);
		
		//recommand F total
		totalclassify = calDAO.Classifyf(week);
		totalclassifyf	= new HashMap<>();
		

		for(CalendarVO temp: totalclassify) {
		if(totalclassifyf.isEmpty()) totalclassifyf.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :totalclassifyf.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) totalclassifyf.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		totalclassifyf = sort.Sorting(totalclassifyf);
		request.setAttribute("totalclassifyf", totalclassifyf);
		
		
		//recommand E total
		totalclassify = calDAO.Classifye(week);
		totalclassifye	= new HashMap<>();
		

		for(CalendarVO temp: totalclassify) {
		if(totalclassifye.isEmpty()) totalclassifye.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :totalclassifye.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) totalclassifye.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		totalclassifye = sort.Sorting(totalclassifye);
		request.setAttribute("totalclassifye", totalclassifye);		
		
		//personal recommand K
		if(request.getSession().getAttribute("id")!=null) {
			String id	= (String)request.getSession().getAttribute("id");
			personalclassify	= calDAO.PClassifyk(id, week);			
			
			personalclassifyk = new HashMap<>();
			if(personalclassify!=null) {
				for(CalendarVO temp: personalclassify) {
					if(personalclassifyk.isEmpty()) personalclassifyk.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:personalclassifyk.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) personalclassifyk.put(temp.getFname(),1);
						count = 0;
					}
				}
				
				personalclassifyk = sort.Sorting(personalclassifyk);
				request.setAttribute("personalclassifyk", personalclassifyk);	
			}
		}
		
			
		return "/main/suggestion";
	}
}
