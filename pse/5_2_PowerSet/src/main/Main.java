package main;

import java.util.HashSet;
import java.util.Set;

import util.PowerSetProvider;

public class Main {

    public static void main(String[] args) {
        Set<Integer> intSet = new HashSet<>();
        for (int i = 1; i <= 10; ++i) {
            intSet.add(i);
        }
        Set<Set<Integer>> powerSet = PowerSetProvider.get(intSet);
        System.out.println(powerSet);
        System.out.println("Size: " + powerSet.size());
    }

    
}
