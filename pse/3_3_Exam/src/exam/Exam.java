package exam;

public abstract class Exam {
	String className;
	int reachablePoints;
	
	public Exam(String className, int reachablePoints) {
		this.className = className;
		this.reachablePoints = reachablePoints;
	}
	
	public abstract void getResult();
}
