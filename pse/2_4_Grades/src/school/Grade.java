package school;

public enum Grade {
	FAIL(1),
	PASS(2),
	SATISFACTORY(3),
	GOOD(4),
	EXCELLENT(5);

	public final int mark;
	
	private Grade(int mark) {
		this.mark = mark;
	}
}
