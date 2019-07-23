package person;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private final String name;
    private final List<Student> students = new ArrayList<>();

    public Teacher(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean doesTeach(Student student) {
    	for (Student s : students) {
        	if (s.getName().equals(student.getName()) && s.getAge() == student.getAge()) {
        		return true;
        	}
            // if the name is the same and the age is the same
            // it returns true
        }
    	return false;
        // else it returns false
    }

    public String getName() {
        return name;
    }
}
