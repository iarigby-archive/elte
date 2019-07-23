package model;

import java.util.Random;


public class Player implements Runnable {

	private String name;
	
	private Boolean isGameEnded;
	
	private int numHats;
	
	private Object head;
	
	private Player nextPlayer;
	
	private int numberOfPlayers;
	
	public Player(String name) {
		this.name = name;
		isGameEnded = true;
		head = new Object();
	}
	
	
	@Override
	public void run() {
		Random random = new Random();
		while (!isGameEnded && !Thread.currentThread().isInterrupted()) {
			System.out.println("something is happening");
			try {
				Thread.sleep(random.nextInt(50));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (head) {
				if (numHats == numberOfPlayers) {
					nextPlayer.endGame();
					isGameEnded = true;
				} else if (numHats >= 1) {
					nextPlayer.putHat();
					numHats--;
				}
			}
		}
		if (numHats == numberOfPlayers) {
			Display.display(name + " lose :(");
		}
	}
	
	public void endGame() {
		if (!isGameEnded) {
			isGameEnded = true;
			nextPlayer.endGame();
		}
	}
	
	public void init(Player nextPlayer, int n) {
		this.nextPlayer = nextPlayer;
		this.numberOfPlayers = n;
		isGameEnded = false;
		numHats = 1;
	}
	
	public void putHat() {
		synchronized (head) {
			numHats++;
		}
	}
	
	public String getName() {
		return name;
	}
	
}
