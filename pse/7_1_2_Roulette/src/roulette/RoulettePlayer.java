package roulette;

public interface RoulettePlayer {
	public void giveCredit(int credit);
	public int nextBetNumber();
	public int nextBetCredit();
	public int getCredit();
}
