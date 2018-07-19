package roulette;

import java.util.*;

public abstract class AbstractPlayer implements RoulettePlayer {
	
	Random rand;
	int credit;
	
	public AbstractPlayer(Random rand) {
		this.rand = rand;
	}
	
	public int  getCredit() {
		return credit;
	}
	
	public void giveCredit(int credit) {
		this.credit += credit;
	}
	

}
