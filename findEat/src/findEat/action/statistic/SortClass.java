package findEat.action.statistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import findEat.DB.bean.CalendarVO;

public class SortClass {

	private List<Map<String, Integer>> monthList	= null;
	private Map<String, Integer> foodTotal			= null;
	private Map<String, Integer> dayFoodTotal		= null;
	private Map<String, Integer> categoryTotal		= null;
	private Map<String, Integer> dayCategoryTotal	= null;
	private Map<String, Integer> result				= null;
	
	//food/category Total map
	public Map<String,Integer> TotalMap(List<CalendarVO> list, String temp) {
		int count	= 0;
		if(temp.equals("food")) {
			foodTotal	= new HashMap<>();
			for(CalendarVO tmp: list) {
				if(foodTotal.isEmpty()) foodTotal.put(tmp.getFname(), 1);
				else {
					for(Entry<String,Integer> x: foodTotal.entrySet()) {
						if(tmp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) foodTotal.put(tmp.getFname(), 1);
					count = 0;
				}
			}
			foodTotal	= Sorting(foodTotal);
			return foodTotal;
		}else if(temp.equals("category")) {
			categoryTotal	= new HashMap<>();
			for(CalendarVO tmp: list) {
				if(categoryTotal.isEmpty()) categoryTotal.put(tmp.getClassify(), 1);
				else {
					for(Entry<String,Integer> x: categoryTotal.entrySet()) {
						if(tmp.getClassify().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) categoryTotal.put(tmp.getClassify(), 1);
					count = 0;
				}
			}
			categoryTotal	= Sorting(categoryTotal);
			return categoryTotal;
		}else {
			return Collections.emptyMap();
		}
	}
	//food/category day Total map
	public Map<String, Integer> DayMap(List<CalendarVO> list, String temp, int day) {
		int count	= 0;
		if(temp.equals("food")) {
			dayFoodTotal	= new HashMap<>();
			for(CalendarVO tmp: list) {
				if(tmp.getFday()==day) {
					if(dayFoodTotal.isEmpty()) dayFoodTotal.put(tmp.getFname(), 1);
					else {
						for(Entry<String,Integer> x: dayFoodTotal.entrySet()) {
							if(tmp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) dayFoodTotal.put(tmp.getFname(), 1);
						count = 0;
					}
				}
			}
			dayFoodTotal	= Sorting(dayFoodTotal);
			return dayFoodTotal;
		}else if(temp.equals("category")) {
			dayCategoryTotal	= new HashMap<>();
			for(CalendarVO tmp: list) {
				if(tmp.getFday()==day) {
					if(dayCategoryTotal.isEmpty()) dayCategoryTotal.put(tmp.getClassify(), 1);
					else {
						for(Entry<String,Integer> x: dayCategoryTotal.entrySet()) {
							if(tmp.getClassify().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) dayCategoryTotal.put(tmp.getClassify(), 1);
						count = 0;
					}
				}
			}
			dayCategoryTotal	= Sorting(dayCategoryTotal);
			return dayCategoryTotal;
		}else {
			return Collections.emptyMap();
		}
	}
	
	//sorting
	public Map<String, Integer> Sorting(Map<String, Integer> temp) {
		
		if(temp==null) temp = Collections.emptyMap();
		
		List<Entry<String, Integer>> list	= new LinkedList<>(temp.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String,Integer>>() {
			public int compare(Entry<String,Integer> o1, Entry<String,Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		result = new LinkedHashMap<>();
		for(Entry<String,Integer> x: list) {
			result.put(x.getKey(), x.getValue());
		}
		return result;
	}
}
