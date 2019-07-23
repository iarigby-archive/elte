package roulette;

import java.util.*;

public class RandomPlayer extends AbstractPlayer {
	
	public RandomPlayer(Random rand) {
		super(rand);
	}
	
	public int nextBetNumber() {
		return rand.nextInt(RouletteTable.MAX_NUMBER + 1);
	}
	
	public int nextBetCredit() {
		int result;
		if (credit < 6) {
			result = credit;
			credit = 0;
		} else {
			result = rand.nextInt(5) + 1;
			credit -= result;
		}
		return result;
	}
	
}
