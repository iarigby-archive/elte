package util;


import java.util.HashSet;
import java.util.Set;

public class PowerSetProvider {
	
	
	public static <E> Set<Set<E>> get(Set<E> set) {
		Set<Set<E>> resultSet = new HashSet<>();
		
		if (set.isEmpty()) {
			resultSet.add(new HashSet<>());
		} else {
			
			E elem = getAnElement(set);
			Set<Set<E>> set2 = get(getSetWithoutElement(set, elem));
			resultSet.addAll(set2);
			for (Set<E> set3 : set2) {
				resultSet.add(getSetWithElement(set3, elem));
			}
				
		}
		return resultSet;
		
		
	}
	
	public static <E> Set<Set<E>> get(E elem) {
		Set<Set<E>> result = new HashSet<>();
		Set<E> element = new HashSet<>();
		element.add(elem);
		result.add(element);
		return result;
	}
	
	
	private static <E> Set<E> getSetWithoutElement(Set<E> set, E elem) {
		Set<E> result = new HashSet<E>(set);
		result.remove(elem);
		return result;
	}
	
	private static <E> Set<E> getSetWithElement(Set<E> set, E elem) {
		Set<E> result = new HashSet<E>(set);
		result.add(elem);
		return result;
	}
	
	private static <E> E getAnElement(Set<E> set) {
		/*int i = 0;
		E e = null;
		do {
			for (E element : set) {
				e = element;
				i++;
			}
		} while (i < 1);
		return e;
		*/
		return set.iterator().next();
	}
	
	private static <E> void addSet(Set<Set<E>> addTo, Set<Set<E>> add) {
		for ( Set<E> set : add) {
			addTo.add(set);
		}	
	}

}
