package roulette;

import java.util.*;

public class TacticalPlayer extends AbstractPlayer {
	private int lastBetNumber;
	private int lastBetCredit;
	
	public TacticalPlayer(Random rand) {
		super(rand);
		lastBetCredit = 1;
	}
	
	public int nextBetNumber() {
		return lastBetNumber;
	}
	
	public int nextBetCredit() {
		int result;
		lastBetCredit++;
		if (lastBetCredit > credit) {
			result = credit;
			credit = 0;
		} else {
			result = lastBetCredit;
			credit -= lastBetCredit;
		}
		return result;
	}
	
	public void giveCredit(int credit) {
		lastBetNumber = rand.nextInt(RouletteTable.MAX_NUMBER + 1);
		super.giveCredit(credit);
	}

}
