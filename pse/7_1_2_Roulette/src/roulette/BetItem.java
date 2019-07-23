package roulette;

public class BetItem {
	
	private int number;
	private int credit;
	private RoulettePlayer roulettePlayer;
	
	public BetItem(RoulettePlayer owner, int number, int credit) {
		this.roulettePlayer = owner;
		this.number = number;
		this.credit = credit;
	}
	
	public RoulettePlayer getOwner() {return roulettePlayer;}
	
	public int getNumber() {return number;}
	
	public int getCredit() {return credit;}
	
	public String toString() { return number + " ";}  
}
