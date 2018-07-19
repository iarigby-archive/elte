package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
	// nub function should remove duplicates, but keep the order of its parameter's elements
	// nub function must not return a new list, it removes elements from the parameter list,
	// then returns it.
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(4);
        integers.add(4);
        integers.add(4);
        List<Integer> nubbedIntegers = nub(integers); // returns [4]
        if (Arrays.asList(4).equals(nubbedIntegers)) {
            System.out.println("nub function works for integers");
        } else {
            System.out.println("It is not working.");
        }

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("two");
        strings.add("four");

        List<String> nubbedStrings = nub(strings); // returns ["one", "two", "three", "four"]
        if (Arrays.asList("one", "two", "three", "four").equals(nubbedStrings)) {
            System.out.println("nub function works for strings");
        } else {
            System.out.println("It is not working.");
        }
    }
    
    public static <T> List<T> nub(List<T> list) {
    	for (int i = 0; i < list.size() ; i++) {
    		for (int j = 0; j < i; j++) {
    			if (list.get(i).equals(list.get(j))) {
    				list.remove(list.get(i));
    			}
    		}
    	}
    	
    	return list;
    }
    
    
}
