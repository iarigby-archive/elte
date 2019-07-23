package main;

import school.Grade;
import school.Student;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Carl", Grade.PASS, Grade.PASS, Grade.FAIL, Grade.GOOD, Grade.EXCELLENT);
        printInfo(s1); // Carl's average: 2.8

        Student s2 = new Student("Julia", Grade.SATISFACTORY, Grade.GOOD, Grade.GOOD);
        printInfo(s2); // Julia's average: 3.6666666666666665

        s2.addGrade(Grade.EXCELLENT);
        printInfo(s2); // Julia's average: 4.0
        
    }

    private static void printInfo(Student s) {
        System.out.println(s.getName() + "'s average: " + s.getAverage());
    }

}