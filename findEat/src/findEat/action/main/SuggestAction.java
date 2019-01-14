package findEat.action.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	private List<CalendarVO> wtotalclassify		= null;	
	private Map<String,Integer> wtotalclassifyk	= null;
	private Map<String,Integer> wtotalclassifyj	= null;
	private Map<String,Integer> wtotalclassifyc	= null;
	private Map<String,Integer> wtotalclassifyw	= null;
	private Map<String,Integer> wtotalclassifyf	= null;
	private Map<String,Integer> wtotalclassifye	= null;
	
	private List<CalendarVO> dpersonalclassify		= null;
	private Map<String,Integer> dpersonalclassifyk	= null;
	private Map<String,Integer> dpersonalclassifyj	= null;
	private Map<String,Integer> dpersonalclassifyc	= null;
	private Map<String,Integer> dpersonalclassifyw	= null;
	private Map<String,Integer> dpersonalclassifyf	= null;
	private Map<String,Integer> dpersonalclassifye	= null;
	
	private List<CalendarVO> wpersonalclassify		= null;
	private Map<String,Integer> wpersonalclassifyk	= null;
	private Map<String,Integer> wpersonalclassifyj	= null;
	private Map<String,Integer> wpersonalclassifyc	= null;
	private Map<String,Integer> wpersonalclassifyw	= null;
	private Map<String,Integer> wpersonalclassifyf	= null;
	private Map<String,Integer> wpersonalclassifye	= null;
	
	private MapSort sort	= new MapSort();						//map 정렬을 위한 함수
	
	private Calendar cal	= new GregorianCalendar();
	
	@Autowired
	private CalendarDAOImpl calDAO	= null;
	
	private void removeKey(Map<String, Integer> map, Set<String> set) {
		for(String key : set) {
			if(map.containsKey(key)) {
				map.remove(key);
			}
		}
	}

	@RequestMapping("suggestion.do")
	public String suggest(HttpServletRequest request) throws Exception {
		//
		int count	= 0;
		int week	= cal.get(Calendar.WEEK_OF_YEAR);
		int day		= cal.get(Calendar.DAY_OF_WEEK) - 1;
		
		//recommand K total(d)
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
		
		
		//recommand J total(d)
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
		
		//recommand C total(d)
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
		
		//recommand W total(d)
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
		
		//recommand F total(d)
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
		
		
		//recommand E total(d)
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
		
		
		
		
		//recommand K total(w)
				wtotalclassify = calDAO.WClassifyk(week);
				wtotalclassifyk	= new HashMap<>();
				

				
				for(CalendarVO temp: wtotalclassify) {
				if(wtotalclassifyk.isEmpty()) wtotalclassifyk.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :wtotalclassifyk.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) wtotalclassifyk.put(temp.getFname(), 1);
					count = 0;
					}
				}
				removeKey(wtotalclassifyk, dtotalclassifyk.keySet());

				wtotalclassifyk = sort.Sorting(wtotalclassifyk);
				request.setAttribute("wtotalclassifyk", wtotalclassifyk);
				/*
				for(Map.Entry<String, Integer> temp: dtotalclassifyk.entrySet()) {
					System.out.println(temp.getKey());
				}
				System.out.println("day value:"+day);
				*/
				
				
				//recommand J total(w)
				wtotalclassify = calDAO.WClassifyj(week);
				wtotalclassifyj	= new HashMap<>();
				

				
				for(CalendarVO temp: wtotalclassify) {
				if(wtotalclassifyj.isEmpty()) wtotalclassifyj.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :wtotalclassifyj.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) wtotalclassifyj.put(temp.getFname(), 1);
					count = 0;
					}
				}
				removeKey(wtotalclassifyj, dtotalclassifyj.keySet());

				wtotalclassifyj = sort.Sorting(wtotalclassifyj);
				request.setAttribute("wtotalclassifyj", wtotalclassifyj);
				
				//recommand C total(w)
				wtotalclassify = calDAO.WClassifyc(week);
				wtotalclassifyc	= new HashMap<>();
				

				
				for(CalendarVO temp: wtotalclassify) {
				if(wtotalclassifyc.isEmpty()) wtotalclassifyc.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :wtotalclassifyc.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) wtotalclassifyc.put(temp.getFname(), 1);
					count = 0;
					}
				}
				removeKey(wtotalclassifyc, dtotalclassifyc.keySet());

				wtotalclassifyk = sort.Sorting(wtotalclassifyc);
				request.setAttribute("wtotalclassifyc", wtotalclassifyc);
				
				//recommand W total(w)
				wtotalclassify = calDAO.WClassifyw(week);
				wtotalclassifyw	= new HashMap<>();
				

				
				for(CalendarVO temp: wtotalclassify) {
				if(wtotalclassifyw.isEmpty()) wtotalclassifyw.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :wtotalclassifyw.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) wtotalclassifyw.put(temp.getFname(), 1);
					count = 0;
					}
				}
				removeKey(wtotalclassifyw, dtotalclassifyw.keySet());

				wtotalclassifyw = sort.Sorting(wtotalclassifyw);
				request.setAttribute("wtotalclassifyw", wtotalclassifyw);
				
				//recommand F total(w)
				wtotalclassify = calDAO.WClassifyf(week);
				wtotalclassifyf	= new HashMap<>();
				

				
				for(CalendarVO temp: wtotalclassify) {
				if(wtotalclassifyf.isEmpty()) wtotalclassifyf.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :wtotalclassifyf.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) wtotalclassifyf.put(temp.getFname(), 1);
					count = 0;
					}
				}
				removeKey(wtotalclassifyf, dtotalclassifyf.keySet());

				wtotalclassifyf = sort.Sorting(wtotalclassifyf);
				request.setAttribute("wtotalclassifyf", wtotalclassifyf);
				
				//recommand E total(w)
				wtotalclassify = calDAO.WClassifye(week);
				wtotalclassifye	= new HashMap<>();
				

				
				for(CalendarVO temp: wtotalclassify) {
				if(wtotalclassifye.isEmpty()) wtotalclassifye.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :wtotalclassifye.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) wtotalclassifye.put(temp.getFname(), 1);
					count = 0;
					}
				}
				removeKey(wtotalclassifye, dtotalclassifye.keySet());

				wtotalclassifye = sort.Sorting(wtotalclassifye);
				request.setAttribute("wtotalclassifye", wtotalclassifye);
		
		
		
		
		//personal recommand K(d)
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
		//personal recommand J(d)
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
			
				//personal recommand C(d)
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
		
				//personal recommand W(d)
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
		
				//personal recommand F(d)
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
		
				//personal recommand E(d)
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
				
				
			
				//personal recommand K(w)
				if(request.getSession().getAttribute("id")!=null) {
					String id	= (String)request.getSession().getAttribute("id");
					wpersonalclassify	= calDAO.WPClassifyk(id, week);			
					
					wpersonalclassifyk = new HashMap<>();
					if(wpersonalclassify!=null) {
						for(CalendarVO temp: wpersonalclassify) {
							if(wpersonalclassifyk.isEmpty()) wpersonalclassifyk.put(temp.getFname(),1);
							else {
								for(Map.Entry<String, Integer> x:wpersonalclassifyk.entrySet()) {
									if(temp.getFname().equals(x.getKey())) {
										x.setValue(x.getValue()+1);
										count++;
									}
								}
								if(count==0) wpersonalclassifyk.put(temp.getFname(),1);
								count = 0;
							}
						}
						removeKey(wpersonalclassifyk, dpersonalclassifyk.keySet());
						
						
						wpersonalclassifyk = sort.Sorting(wpersonalclassifyk);
						request.setAttribute("wpersonalclassifyk", wpersonalclassifyk);	
					}
				}
				//personal recommand J(w)
						if(request.getSession().getAttribute("id")!=null) {
							String id	= (String)request.getSession().getAttribute("id");
							wpersonalclassify	= calDAO.WPClassifyj(id, week);			
							
							wpersonalclassifyj = new HashMap<>();
							if(wpersonalclassify!=null) {
								for(CalendarVO temp: wpersonalclassify) {
									if(wpersonalclassifyj.isEmpty()) wpersonalclassifyj.put(temp.getFname(),1);
									else {
										for(Map.Entry<String, Integer> x:wpersonalclassifyj.entrySet()) {
											if(temp.getFname().equals(x.getKey())) {
												x.setValue(x.getValue()+1);
												count++;
											}
										}
										if(count==0) wpersonalclassifyj.put(temp.getFname(),1);
										count = 0;
									}
								}
								removeKey(wpersonalclassifyj, dpersonalclassifyj.keySet());
								
								wpersonalclassifyj = sort.Sorting(wpersonalclassifyj);
								request.setAttribute("wpersonalclassifyj", wpersonalclassifyj);	
							}
						}
					
						//personal recommand C(w)
						if(request.getSession().getAttribute("id")!=null) {
							String id	= (String)request.getSession().getAttribute("id");
							wpersonalclassify	= calDAO.WPClassifyc(id, week);			
							
							wpersonalclassifyc = new HashMap<>();
							if(wpersonalclassify!=null) {
								for(CalendarVO temp: wpersonalclassify) {
									if(wpersonalclassifyc.isEmpty()) wpersonalclassifyc.put(temp.getFname(),1);
									else {
										for(Map.Entry<String, Integer> x:wpersonalclassifyc.entrySet()) {
											if(temp.getFname().equals(x.getKey())) {
												x.setValue(x.getValue()+1);
												count++;
											}
										}
										if(count==0) wpersonalclassifyc.put(temp.getFname(),1);
										count = 0;
									}
								}
								
								removeKey(wpersonalclassifyc, dpersonalclassifyc.keySet());
								wpersonalclassifyc = sort.Sorting(wpersonalclassifyc);
								request.setAttribute("wpersonalclassifyc", wpersonalclassifyc);	
							}
						}		
				
						//personal recommand W(w)
						if(request.getSession().getAttribute("id")!=null) {
							String id	= (String)request.getSession().getAttribute("id");
							wpersonalclassify	= calDAO.WPClassifyw(id, week);			
							
							wpersonalclassifyw = new HashMap<>();
							if(wpersonalclassify!=null) {
								for(CalendarVO temp: wpersonalclassify) {
									if(wpersonalclassifyw.isEmpty()) wpersonalclassifyw.put(temp.getFname(),1);
									else {
										for(Map.Entry<String, Integer> x:wpersonalclassifyw.entrySet()) {
											if(temp.getFname().equals(x.getKey())) {
												x.setValue(x.getValue()+1);
												count++;
											}
										}
										if(count==0) wpersonalclassifyw.put(temp.getFname(),1);
										count = 0;
									}
								}
								
								removeKey(wpersonalclassifyw, dpersonalclassifyw.keySet());
								wpersonalclassifyw = sort.Sorting(wpersonalclassifyw);
								request.setAttribute("wpersonalclassifyw", wpersonalclassifyw);	
							}
						}		
				
						//personal recommand F(w)
						if(request.getSession().getAttribute("id")!=null) {
							String id	= (String)request.getSession().getAttribute("id");
							wpersonalclassify	= calDAO.WPClassifyf(id, week);			
							
							wpersonalclassifyf = new HashMap<>();
							if(wpersonalclassify!=null) {
								for(CalendarVO temp: wpersonalclassify) {
									if(wpersonalclassifyf.isEmpty()) wpersonalclassifyf.put(temp.getFname(),1);
									else {
										for(Map.Entry<String, Integer> x:wpersonalclassifyf.entrySet()) {
											if(temp.getFname().equals(x.getKey())) {
												x.setValue(x.getValue()+1);
												count++;
											}
										}
										if(count==0) wpersonalclassifyf.put(temp.getFname(),1);
										count = 0;
									}
								}
								
								removeKey(wpersonalclassifyf, dpersonalclassifyf.keySet());
								wpersonalclassifyf = sort.Sorting(wpersonalclassifyf);
								request.setAttribute("wpersonalclassifyf", wpersonalclassifyf);	
							}
						}		
				
						//personal recommand E(w)
						if(request.getSession().getAttribute("id")!=null) {
							String id	= (String)request.getSession().getAttribute("id");
							wpersonalclassify	= calDAO.WPClassifye(id, week);			
							
							wpersonalclassifye = new HashMap<>();
							if(wpersonalclassify!=null) {
								for(CalendarVO temp: wpersonalclassify) {
									if(wpersonalclassifye.isEmpty()) wpersonalclassifye.put(temp.getFname(),1);
									else {
										for(Map.Entry<String, Integer> x:wpersonalclassifye.entrySet()) {
											if(temp.getFname().equals(x.getKey())) {
												x.setValue(x.getValue()+1);
												count++;
											}
										}
										if(count==0) wpersonalclassifye.put(temp.getFname(),1);
										count = 0;
									}
								}
								removeKey(wpersonalclassifye, dpersonalclassifye.keySet());
								wpersonalclassifye = sort.Sorting(wpersonalclassifye);
								request.setAttribute("wpersonalclassifye", wpersonalclassifye);	
							}
						}			
				
		return "/main/suggestion";
	}
}
