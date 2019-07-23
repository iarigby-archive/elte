package exam;


public class ProgrammingExam extends Exam {
	
	public ProgrammingExam(String className, Task...tasks ) {
		super(className, Task.sum(tasks));				
	}
	
	public void getResult() {
		System.out.println("Well done! You get 5!");
	}
	
}
