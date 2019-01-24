package findEat.action.statistic;

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
			categoryTotal.put("한식",0);
			categoryTotal.put("일식",0);
			categoryTotal.put("중식",0);
			categoryTotal.put("양식",0);
			categoryTotal.put("패스트푸드/분식",0);
			categoryTotal.put("기타",0);
			for(CalendarVO tmp: list) {
				for(Entry<String,Integer> x: categoryTotal.entrySet()) {
					if(tmp.getClassify().equals("k")) {
						if(x.getKey().equals("한식")) x.setValue(x.getValue()+1);
					}else if(tmp.getClassify().equals("j")) {
						if(x.getKey().equals("일식")) x.setValue(x.getValue()+1);
					}else if(tmp.getClassify().equals("c")) {
						if(x.getKey().equals("중식")) x.setValue(x.getValue()+1);
					}else if(tmp.getClassify().equals("w")) {
						if(x.getKey().equals("양식")) x.setValue(x.getValue()+1);
					}else if(tmp.getClassify().equals("f")) {
						if(x.getKey().equals("패스트푸드/분식")) x.setValue(x.getValue()+1);
					}else if(tmp.getClassify().equals("e")) {
						if(x.getKey().equals("기타")) x.setValue(x.getValue()+1);
					}
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
			dayCategoryTotal.put("한식",0);
			dayCategoryTotal.put("일식",0);
			dayCategoryTotal.put("중식",0);
			dayCategoryTotal.put("양식",0);
			dayCategoryTotal.put("패스트푸드/분식",0);
			dayCategoryTotal.put("기타",0);
			for(CalendarVO tmp: list) {
				if(tmp.getFday()==day) {
					for(Entry<String,Integer> x: dayCategoryTotal.entrySet()) {
						if(tmp.getClassify().equals("k")) {
							if(x.getKey().equals("한식")) x.setValue(x.getValue()+1);
						}else if(tmp.getClassify().equals("j")) {
							if(x.getKey().equals("일식")) x.setValue(x.getValue()+1);
						}else if(tmp.getClassify().equals("c")) {
							if(x.getKey().equals("중식")) x.setValue(x.getValue()+1);
						}else if(tmp.getClassify().equals("w")) {
							if(x.getKey().equals("양식")) x.setValue(x.getValue()+1);
						}else if(tmp.getClassify().equals("f")) {
							if(x.getKey().equals("패스트푸드/분식")) x.setValue(x.getValue()+1);
						}else if(tmp.getClassify().equals("e")) {
							if(x.getKey().equals("기타")) x.setValue(x.getValue()+1);
						}
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
	
	//Empty value check
	public Map<String, Integer> EmptyCheck(Map<String, Integer> map) {
		int check	= map.size();
		int count	= 1;
		String temp	= "Empty";
		if(check < 10) {
			do {
				temp+=count;
				map.put(temp, 0);
				check = map.size();
				count++;
				temp = "Empty";
			}while(check<11);
		}
		return map;
	}
}
