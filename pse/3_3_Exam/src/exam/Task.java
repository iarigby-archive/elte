package exam;

public class Task {
	private int points;
	
	public static int sum(Task...tasks) {
		int sum = 0;
		for (Task task : tasks) {
			sum += task.getPoints();
		}
		return sum;
	}
	
	public Task(int points) {
		this.points = points;
	}
	
	public int getPoints() {return points;}
}
