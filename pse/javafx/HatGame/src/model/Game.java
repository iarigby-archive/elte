package model;

import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable {
	
//	Create a players field, which holds all the players throughout the game
	private List<Player> players = new ArrayList<Player>();
	private List<Thread> threads = new ArrayList<Thread>();
	
	public void addPlayer(String name) {
		players.add(new Player(name));
	}
	
	@Override
	public void run() {
		int n = players.size();
		for (int i = 0; i < players.size()-1; i++) {
			players.get(i).init(players.get(i+1), n);
			threads.add(new Thread(players.get(i)));
		}
		players.get(n-1).init(players.get(0), n);
		threads.add(new Thread(players.get(n-1)));
		for (Thread thread : threads) {
			thread.start();
		}
	}
	
}
