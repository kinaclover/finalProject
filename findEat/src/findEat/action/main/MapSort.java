package findEat.action.main;

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

public class MapSort {

	/***********************************************************************************************************************/
	/*	
	 *	*** 분류,정렬을 위한 클래스
	 * 
	 *	index 페이지의 정보 계산을 위한 class
	 *	- DB에서 받아온 리스트를 분류,정렬 하기위한 메소드 작성
	 *
	/***********************************************************************************************************************/
	
	private Map<String, Integer> insert = null;
	private Map<String, Integer> result = null;
	private List<CalendarVO> resultList	= null;
	
	//전체 리스트에서 해당 id에 해당하는 값 만을 분류
	public List<CalendarVO> SetListByID(List<CalendarVO> list,String id) {
		resultList	= new ArrayList<>();
		for(CalendarVO temp: list) {
			if(temp.getId().equals(id)) resultList.add(temp);
		}
		return resultList;
	}
	
	//total
	//전달 받은 리스트에서 해당 분류의 값만을 분류, 정렬 함수 실행
	public Map<String, Integer> SetListByClassify(List<CalendarVO> list,String classify) {
		
		resultList	= new ArrayList<>();
		for(CalendarVO temp: list) {
			if(temp.getClassify().equals(classify)) resultList.add(temp);
		}
		//정렬 함수 실행
		result	= InsertAndSort(resultList);
		
		return result;
	}
	//personal(user)
	//전달 받은 리스트에서 해당 분류의 값만을 분류, 정렬 함수 실행
	public Map<String, Integer> SetListByClassifyWeek(List<CalendarVO> list,String classify,List<String> weekList) {
		resultList	= new ArrayList<>();
		for(CalendarVO temp: list) {
			if(temp.getClassify().equals(classify)) resultList.add(temp);
		}
		//정렬 함수 실행
		result	= InsertAndSortWeek(resultList,weekList);
		
		return result;
	}
	
	//전달 받은 리스트의 음식 이름을 기준으로 중복값 처리 후 내림차순으로 정렬
	public Map<String, Integer> InsertAndSort(List<CalendarVO> list) {
		
		int count 	= 0;
		insert		= new HashMap<>();
		if(list==null) list = Collections.emptyList();
		
		if(!list.isEmpty()) {
			for(CalendarVO temp: list) {
				if(insert.isEmpty()) insert.put(temp.getFname(), 1);
				else {
					for(Entry<String,Integer> x: insert.entrySet()) {
						if(x.getKey().equals(temp.getFname())) {
							x.setValue((x.getValue()+1));
							count++;
						}
					}
					if(count==0) insert.put(temp.getFname(), 1);
					count = 0;
				}
			}
		}
		
		List<Entry<String, Integer>> target	= new LinkedList<>(insert.entrySet());
		
		Collections.sort(target, new Comparator<Entry<String,Integer>>() {
			public int compare(Entry<String,Integer> o1, Entry<String,Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		result = new LinkedHashMap<>();
		for(Entry<String,Integer> x: target) {
			result.put(x.getKey(), x.getValue());
		}
		
		return result;
	}
	//list의 항목중 weekList와 겹치는것이 있으면 제외한 뒤, 음식 이름을 기준으로 중복값 처리 후 내림차순으로 정렬
	public Map<String, Integer> InsertAndSortWeek(List<CalendarVO> list, List<String> weekList) {
		
		int count 	= 0;
		int delChk	= 0;
		insert		= new HashMap<>();
		
		if(list==null) list = Collections.emptyList();
		
		if(!list.isEmpty()) {
			for(CalendarVO temp: list) {
				for(String test: weekList) {
					if(temp.getFname().equals(test)) delChk++;
				}
				if(delChk==0) {
					if(insert.isEmpty()) insert.put(temp.getFname(), 1);
					else {
						for(Entry<String,Integer> x: insert.entrySet()) {
							if(x.getKey().equals(temp.getFname())) {
								x.setValue((x.getValue()+1));
								count++;
							}
						}
						if(count==0) insert.put(temp.getFname(), 1);
						count = 0;
					}
				}
				delChk = 0;
			}
		}
		
		List<Entry<String, Integer>> target	= new LinkedList<>(insert.entrySet());
		
		Collections.sort(target, new Comparator<Entry<String,Integer>>() {
			public int compare(Entry<String,Integer> o1, Entry<String,Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		result = new LinkedHashMap<>();
		for(Entry<String,Integer> x: target) {
			result.put(x.getKey(), x.getValue());
		}
		
		return result;
	}
	
	/**************************************************************************************************************************/
	//SuggestAction 자료용
	/***** 전체 통계용 자료 *****/
	public Map<String, Integer> TotalClassify(List<CalendarVO> list) {
		if(list==null) list	= Collections.emptyList();
		result		= new HashMap<>();		
		result.put("한식", 0);
		result.put("일식", 0);
		result.put("중식", 0);
		result.put("양식", 0);
		result.put("패스트푸드/분식", 0);
		result.put("기타", 0);
		
		if(!list.isEmpty()) {
			for(CalendarVO tmp: list) {
				for(Entry<String,Integer> x: result.entrySet()) {
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
		return result;
	}
	/**************************************************************************************************************************/
	//WeekAction 자료용
	//전달 받은 리스트에서 해당 요일값에 해당하는 값을 분류,정렬
	public Map<String, Integer> ListUpforDay(List<CalendarVO> list, int day) {
		insert 		= new HashMap<>();
		int count	= 0;
		for(CalendarVO temp: list) {
			if(temp.getFday()==day) {
				if(insert.isEmpty()) insert.put(temp.getFname(),1);
				else {
					for(Map.Entry<String, Integer> x:insert.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) insert.put(temp.getFname(),1);
					count = 0;
				}
			}
		}
		result	= Sorting(insert);
		
		return result;
	}
	/**************************************************************************************************************************/
	
	//공통사용
	//내림차순 정렬 메소드
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
