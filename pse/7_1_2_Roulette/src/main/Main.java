package main;

import java.util.Random;
import roulette.*;

public class Main {
    
    public static void main(String[] args) {
        Random rnd = new Random(1);
        RouletteTable table = new RouletteTable(rnd);
        table.join(new RandomPlayer(rnd));
        table.join(new RandomPlayer(rnd));
        table.join(new TacticalPlayer(rnd));
        table.join(new TacticalPlayer(rnd));
        table.giveCreditToAll(100);
        for (int i = 0; i < 100; ++i) {
            table.betsPlease();
            table.spin();
            table.payWinners();
            System.out.println(table.getPlayersCredits());
        }
    }
    
}
