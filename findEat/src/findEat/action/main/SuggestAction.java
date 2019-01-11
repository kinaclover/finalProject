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
	
	private List<CalendarVO> dtotalclassify		= null;	
	private Map<String,Integer> dtotalclassifyk	= null;
	private Map<String,Integer> dtotalclassifyj	= null;
	private Map<String,Integer> dtotalclassifyc	= null;
	private Map<String,Integer> dtotalclassifyw	= null;
	private Map<String,Integer> dtotalclassifyf	= null;
	private Map<String,Integer> dtotalclassifye	= null;
	
	private List<CalendarVO> dpersonalclassify		= null;
	private Map<String,Integer> dpersonalclassifyk	= null;
	private Map<String,Integer> dpersonalclassifyj	= null;
	private Map<String,Integer> dpersonalclassifyc	= null;
	private Map<String,Integer> dpersonalclassifyw	= null;
	private Map<String,Integer> dpersonalclassifyf	= null;
	private Map<String,Integer> dpersonalclassifye	= null;
	
	private MapSort sort	= new MapSort();						//map 정렬을 위한 함수
	
	private Calendar cal	= new GregorianCalendar();
	
	@Autowired
	private CalendarDAOImpl calDAO	= null;

	@RequestMapping("suggestion.do")
	public String suggest(HttpServletRequest request) throws Exception {
		//
		int count	= 0;
		int week	= cal.get(Calendar.WEEK_OF_YEAR);
		int day		= cal.get(Calendar.DAY_OF_WEEK) - 1;
		
		//recommand K total
		dtotalclassify = calDAO.DClassifyk(week, day);
		dtotalclassifyk	= new HashMap<>();
		
		
		for(CalendarVO temp: dtotalclassify) {
		if(dtotalclassifyk.isEmpty()) dtotalclassifyk.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :dtotalclassifyk.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) dtotalclassifyk.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		dtotalclassifyk = sort.Sorting(dtotalclassifyk);
		request.setAttribute("dtotalclassifyk", dtotalclassifyk);
		/*
		for(Map.Entry<String, Integer> temp: dtotalclassifyk.entrySet()) {
			System.out.println(temp.getKey());
		}
		System.out.println("day value:"+day);
		*/
		
		
		//recommand J total
		dtotalclassify = calDAO.DClassifyj(week, day);
		dtotalclassifyj	= new HashMap<>();

		for(CalendarVO temp: dtotalclassify) {
		if(dtotalclassifyj.isEmpty()) dtotalclassifyj.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :dtotalclassifyj.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) dtotalclassifyj.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		dtotalclassifyj = sort.Sorting(dtotalclassifyj);
		request.setAttribute("dtotalclassifyj", dtotalclassifyj);
		
		//recommand C total
		dtotalclassify = calDAO.DClassifyc(week, day);
		dtotalclassifyc	= new HashMap<>();
		

		for(CalendarVO temp: dtotalclassify) {
		if(dtotalclassifyc.isEmpty()) dtotalclassifyc.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :dtotalclassifyc.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) dtotalclassifyc.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		dtotalclassifyc = sort.Sorting(dtotalclassifyc);
		request.setAttribute("dtotalclassifyc", dtotalclassifyc);
		
		//recommand W total
		dtotalclassify = calDAO.DClassifyw(week, day);
		dtotalclassifyw	= new HashMap<>();
		

		for(CalendarVO temp: dtotalclassify) {
		if(dtotalclassifyw.isEmpty()) dtotalclassifyw.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :dtotalclassifyw.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) dtotalclassifyw.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		dtotalclassifyw = sort.Sorting(dtotalclassifyw);
		request.setAttribute("dtotalclassifyw", dtotalclassifyw);
		
		//recommand F total
		dtotalclassify = calDAO.DClassifyf(week, day);
		dtotalclassifyf	= new HashMap<>();
		

		for(CalendarVO temp: dtotalclassify) {
		if(dtotalclassifyf.isEmpty()) dtotalclassifyf.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :dtotalclassifyf.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) dtotalclassifyf.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		dtotalclassifyf = sort.Sorting(dtotalclassifyf);
		request.setAttribute("dtotalclassifyf", dtotalclassifyf);
		
		
		//recommand E total
		dtotalclassify = calDAO.DClassifye(week, day);
		dtotalclassifye	= new HashMap<>();
		

		for(CalendarVO temp: dtotalclassify) {
		if(dtotalclassifye.isEmpty()) dtotalclassifye.put(temp.getFname(), 1);
		else {
			for(Map.Entry<String, Integer> x :dtotalclassifye.entrySet()) {
				if(temp.getFname().equals(x.getKey())) {
					x.setValue(x.getValue()+1);
					count++;
				}
			}
			if(count==0) dtotalclassifye.put(temp.getFname(), 1);
			count = 0;
			}
		}
		
		dtotalclassifye = sort.Sorting(dtotalclassifye);
		request.setAttribute("dtotalclassifye", dtotalclassifye);		
		
		//personal recommand K
		if(request.getSession().getAttribute("id")!=null) {
			String id	= (String)request.getSession().getAttribute("id");
			dpersonalclassify	= calDAO.DPClassifyk(id, week, day);			
			
			dpersonalclassifyk = new HashMap<>();
			if(dpersonalclassify!=null) {
				for(CalendarVO temp: dpersonalclassify) {
					if(dpersonalclassifyk.isEmpty()) dpersonalclassifyk.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:dpersonalclassifyk.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) dpersonalclassifyk.put(temp.getFname(),1);
						count = 0;
					}
				}
				
				dpersonalclassifyk = sort.Sorting(dpersonalclassifyk);
				request.setAttribute("dpersonalclassifyk", dpersonalclassifyk);	
			}
		}
		//personal recommand J
				if(request.getSession().getAttribute("id")!=null) {
					String id	= (String)request.getSession().getAttribute("id");
					dpersonalclassify	= calDAO.DPClassifyj(id, week, day);			
					
					dpersonalclassifyj = new HashMap<>();
					if(dpersonalclassify!=null) {
						for(CalendarVO temp: dpersonalclassify) {
							if(dpersonalclassifyj.isEmpty()) dpersonalclassifyj.put(temp.getFname(),1);
							else {
								for(Map.Entry<String, Integer> x:dpersonalclassifyj.entrySet()) {
									if(temp.getFname().equals(x.getKey())) {
										x.setValue(x.getValue()+1);
										count++;
									}
								}
								if(count==0) dpersonalclassifyj.put(temp.getFname(),1);
								count = 0;
							}
						}
						
						dpersonalclassifyj = sort.Sorting(dpersonalclassifyj);
						request.setAttribute("dpersonalclassifyj", dpersonalclassifyj);	
					}
				}
			
				//personal recommand C
				if(request.getSession().getAttribute("id")!=null) {
					String id	= (String)request.getSession().getAttribute("id");
					dpersonalclassify	= calDAO.DPClassifyc(id, week, day);			
					
					dpersonalclassifyc = new HashMap<>();
					if(dpersonalclassify!=null) {
						for(CalendarVO temp: dpersonalclassify) {
							if(dpersonalclassifyc.isEmpty()) dpersonalclassifyc.put(temp.getFname(),1);
							else {
								for(Map.Entry<String, Integer> x:dpersonalclassifyc.entrySet()) {
									if(temp.getFname().equals(x.getKey())) {
										x.setValue(x.getValue()+1);
										count++;
									}
								}
								if(count==0) dpersonalclassifyc.put(temp.getFname(),1);
								count = 0;
							}
						}
						
						dpersonalclassifyc = sort.Sorting(dpersonalclassifyc);
						request.setAttribute("dpersonalclassifyc", dpersonalclassifyc);	
					}
				}		
		
				//personal recommand W
				if(request.getSession().getAttribute("id")!=null) {
					String id	= (String)request.getSession().getAttribute("id");
					dpersonalclassify	= calDAO.DPClassifyw(id, week, day);			
					
					dpersonalclassifyw = new HashMap<>();
					if(dpersonalclassify!=null) {
						for(CalendarVO temp: dpersonalclassify) {
							if(dpersonalclassifyw.isEmpty()) dpersonalclassifyw.put(temp.getFname(),1);
							else {
								for(Map.Entry<String, Integer> x:dpersonalclassifyw.entrySet()) {
									if(temp.getFname().equals(x.getKey())) {
										x.setValue(x.getValue()+1);
										count++;
									}
								}
								if(count==0) dpersonalclassifyw.put(temp.getFname(),1);
								count = 0;
							}
						}
						
						dpersonalclassifyw = sort.Sorting(dpersonalclassifyw);
						request.setAttribute("dpersonalclassifyw", dpersonalclassifyw);	
					}
				}		
		
				//personal recommand F
				if(request.getSession().getAttribute("id")!=null) {
					String id	= (String)request.getSession().getAttribute("id");
					dpersonalclassify	= calDAO.DPClassifyf(id, week, day);			
					
					dpersonalclassifyf = new HashMap<>();
					if(dpersonalclassify!=null) {
						for(CalendarVO temp: dpersonalclassify) {
							if(dpersonalclassifyf.isEmpty()) dpersonalclassifyf.put(temp.getFname(),1);
							else {
								for(Map.Entry<String, Integer> x:dpersonalclassifyf.entrySet()) {
									if(temp.getFname().equals(x.getKey())) {
										x.setValue(x.getValue()+1);
										count++;
									}
								}
								if(count==0) dpersonalclassifyf.put(temp.getFname(),1);
								count = 0;
							}
						}
						
						dpersonalclassifyf = sort.Sorting(dpersonalclassifyf);
						request.setAttribute("dpersonalclassifyf", dpersonalclassifyf);	
					}
				}		
		
				//personal recommand E
				if(request.getSession().getAttribute("id")!=null) {
					String id	= (String)request.getSession().getAttribute("id");
					dpersonalclassify	= calDAO.DPClassifye(id, week, day);			
					
					dpersonalclassifye = new HashMap<>();
					if(dpersonalclassify!=null) {
						for(CalendarVO temp: dpersonalclassify) {
							if(dpersonalclassifye.isEmpty()) dpersonalclassifye.put(temp.getFname(),1);
							else {
								for(Map.Entry<String, Integer> x:dpersonalclassifye.entrySet()) {
									if(temp.getFname().equals(x.getKey())) {
										x.setValue(x.getValue()+1);
										count++;
									}
								}
								if(count==0) dpersonalclassifye.put(temp.getFname(),1);
								count = 0;
							}
						}
						
						dpersonalclassifye = sort.Sorting(dpersonalclassifye);
						request.setAttribute("dpersonalclassifye", dpersonalclassifye);	
					}
				}		
				
		return "/main/suggestion";
	}
}
