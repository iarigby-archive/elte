package school;

public class Student {
	private String name;
	private Grade[] grades; 
	
	public Student(String name, Grade... grades) {
		this.name = name;
		this.grades = grades;
	}
	
	public int getAverage() { 
		if (grades.length > 0) {
			int sum = 0;
			for (int i = 0; i < grades.length; i++) {
				sum += grades[i].mark;
			}
			return sum / grades.length;
		}
		return 0;	
	}
	
	public void addGrade(Grade grade) {
		Grade[] temp = grades;
		grades = new Grade[temp.length];
		for (int i = 0; i < temp.length; i++) {
			grades[i] = temp[i];
		}
		grades[grades.length-1] = grade;
	}
	
	public String getName() { return this.name; }
	
	
	
}
