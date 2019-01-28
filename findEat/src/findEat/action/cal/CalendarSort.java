package findEat.action.cal;

import java.util.Comparator;

import findEat.DB.bean.FoodVO;

public class CalendarSort implements Comparator<FoodVO>{

	@Override
	public int compare(FoodVO o1, FoodVO o2) {
		int firstValue	= o1.getFcount();
		int secondValue	= o2.getFcount();
		if(firstValue > secondValue)		return -1;
		else if(firstValue < secondValue)	return 1;
		else return 0;
	}
	
}
