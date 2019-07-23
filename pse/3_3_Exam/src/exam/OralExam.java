package exam;

import java.util.ArrayList;

public class OralExam extends Exam {
	
	ArrayList<String> topic = new ArrayList();
	
	public OralExam(String className, String topic) {
		super(className, 5);
		this.topic.add(topic);
	}
	
	public void getResult() {
		System.out.println("I'm sorry, this is not enough, you failed.");
	}
	
	public void addEasierTopic(String topic) {
		if (this.topic.size() < 3) {
			this.topic.add(topic);
		}
	}
}
