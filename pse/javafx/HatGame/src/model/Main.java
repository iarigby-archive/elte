package model;

public class Main {
	public static void main(String[] args) {
		Game g = new Game();
		g.addPlayer("Rudi");
		g.addPlayer("Tamás");
		g.addPlayer("Rudi2");
		g.addPlayer("Tamás2");
		g.run();
	}
}
