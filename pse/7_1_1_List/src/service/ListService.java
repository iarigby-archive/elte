package service;

import java.util.Arrays;
import java.util.List;

public class ListService {
	public static List<Integer> mergeSort(List<Integer> list1, List<Integer> list2) {
		List<Integer> result = null;

		int i=0;
		int j=0;
		while (i < list1.size() || j < list2.size()) {
			
			if (list1.get(i) <= list2.get(j)) {
				result.add(list1.get(i));
				i++;
			} else {
				result.add(list2.get(j));
				j++;
			}	
		}
		
		return result;
	}
}
