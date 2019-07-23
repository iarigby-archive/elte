package roulette;

import java.util.*;

public class RouletteTable {
	public static int MAX_NUMBER = 36;
	
	private Random rand;
	private int lastNumber;
	private List<RoulettePlayer> players = new ArrayList<RoulettePlayer>();
	private List<BetItem> bets = new ArrayList<BetItem>();
	
	
	public RouletteTable(Random rand) {
		this.rand = rand;
	}
	
	public void join(RoulettePlayer rp) {
		players.add(rp);
	}
	
	public void betsPlease() {
		bets.clear();
		for (RoulettePlayer player : players) {
			bets.add(new BetItem(player, player.nextBetNumber(), player.nextBetCredit()));
		}
		System.out.println(bets);
	}
	
	public void giveCreditToAll(int credit) {
		for (RoulettePlayer player : players) {
			player.giveCredit(credit);
		}
	}
	
	public int spin() {
		lastNumber = rand.nextInt(MAX_NUMBER);
		return lastNumber;
	}
	
	public void payWinners() {
		for (BetItem bet : bets) {
			if (bet.getNumber() == lastNumber) {
				bet.getOwner().giveCredit(bet.getCredit()*36);
			}
		}
	}
	
	public List<Integer> getPlayersCredits() {
		List<Integer> result = new ArrayList<Integer>();	
		for (RoulettePlayer player : players) {
			result.add(player.getCredit());
		}
		return result;
	}
	
}
