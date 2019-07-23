package main;

import java.util.Arrays;
import java.util.List;

import service.ListService;

public class Main {

    public static void main(String[] args) {
        List<Integer> sortedList1 = Arrays.asList(1, 3, 4, 4, 6);
        List<Integer> sortedList2 = Arrays.asList(1, 4, 5, 5, 5, 7);
        System.out.println("result == " + ListService.mergeSort(sortedList1, sortedList2)); 
        // result == [1, 1, 3, 4, 4, 4, 5, 5, 5, 6, 7]
    }

}
