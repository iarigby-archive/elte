package main;

import java.util.ArrayList;
import java.util.List;

import exam.Exam;
import exam.OralExam;
import exam.ProgrammingExam;
import exam.Task;

public class Main {

    public static void main(String[] args) {
        List<Exam> exams = new ArrayList<>();

        OralExam oralExam = new OralExam("PSE1", "polymorphism");
        exams.add(oralExam);
        oralExam.addEasierTopic("inheritance");
        oralExam.addEasierTopic("getters, setters");
        oralExam.addEasierTopic("encapsulation"); // it's more than 3

        exams.add(new ProgrammingExam("PSE1", new Task(10), new Task(15)));
        exams.forEach(Exam::getResult); // we loop through the exams and call the getResult method on each
    }

}
