package findEat.action.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapSort {
	
	private Map<String, Integer> result = null;
	
	public Map<String, Integer> Sorting(Map<String, Integer> temp) {
		
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
