package model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PairTable {
    
    private int size;
    private int[][] table;
    private Coordinate firstOfRound;
    private Coordinate secondOfRound;
    private int numberOfDiscoveredFields;
    private final Random rand = new Random();

    public void newGame(int size) {
        this.size = size;
        table = new int[size][size];
        firstOfRound = null;
        secondOfRound = null;
        numberOfDiscoveredFields = 0;
        shuffleTable();
    }

    public int getField(int i, int j) {
        return table[i][j];
    }

    private void shuffleTable() {
        for (int pair = 1; pair < size * size / 2; ++pair) {
            int counter = 0;
            do {
                int x, y;
                do {
                    x = rand.nextInt(size);
                    y = rand.nextInt(size);
                } while (table[x][y] != 0);
                table[x][y] = pair;
                ++counter;
            } while (counter < 2);
        }
    }

    public void discover(int i, int j) {
        Coordinate coordinate = new Coordinate(i, j);
        if (firstOfRound == null) {
            firstOfRound = coordinate;
        } else {
            secondOfRound = coordinate;
        }
    }

    public void newRound() {
        if (checkPairs()) {
            numberOfDiscoveredFields++;
        }
        firstOfRound = null;
        secondOfRound = null;
    }

    public boolean checkPairs() {
        return bothDiscovered() && fieldsAreSame();
    }

    public boolean bothDiscovered() {
        return firstOfRound != null && secondOfRound != null;
    }

    private boolean fieldsAreSame() {
        return table[firstOfRound.getX()][firstOfRound.getY()] == table[secondOfRound.getX()][secondOfRound.getY()];
    }

    public Set<Coordinate> getPairCoordinates() {
        Set<Coordinate> result = new HashSet<>(2);
        result.add(firstOfRound);
        result.add(secondOfRound);
        return result;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size * size / 2 == numberOfDiscoveredFields;
    }

}
