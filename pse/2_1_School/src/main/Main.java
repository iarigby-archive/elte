package main;

import person.Student;
import person.Teacher;

public class Main {

    public static void main(String[] args) {
        Student s = new Student("Tamas", 23);

        System.out.println(s.getName());
        System.out.println(s.getAge());

        Student s2 = new Student("John", 20);
        Student s3 = new Student("Jane", 20);

        Teacher t = new Teacher("Andrea");
        t.addStudent(s);
        t.addStudent(s2);

        test(t, s2);
        test(t, s3);
    }

    private static void test(Teacher t, Student s) {
        if (t.doesTeach(s)) {
            System.out.println(t.getName() + " teaches " + s.getName());
        } else {
            System.out.println(t.getName() + " does not teach " + s.getName());
        }
    }

}
