package bowling;

public class Game {
	
	private final int[] rolls = new int[21];
	private int currentRoll = 0;
	
	public void roll(int pins)  {
		rolls[currentRoll++] = pins;
	}
	
	public int score() {
		int score = 0;
		int firstInFrame = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isSpare(firstInFrame))
			//score += rolls[firstInFrame] + rolls[];
			firstInFrame += 2;
		}
		return score;
	}

	private boolean isSpare(int firstInFrame) {
		return rolls[firstInFrame] + rolls[firstInFrame+1] == 10;
	}
}
