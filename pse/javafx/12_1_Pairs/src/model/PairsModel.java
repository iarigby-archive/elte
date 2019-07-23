package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PairsModel {

	private ArrayList<Integer> pairsTable = new ArrayList<Integer>();
	private  Random random = new Random();
	private int maxNumber;
	private int[][] gameTable;
	private int openedCounter;
	private boolean gameWon;
	private int width;
	private int currentValue;
	
	public PairsModel(int maxNumber) {
		this.maxNumber = maxNumber;
		openedCounter = 0;
		currentValue = -1;
	}
	
	public void GenerateTable(int width) {
		this.width = width;
		gameTable = new int[width][width];
		pairsTable.clear();
		for (int[] row : gameTable) {
			Arrays.fill(row, -1);			
		}
		for (int i = 0; i < width*width/2; i++) {

			int elem;
			do {
				elem = random.nextInt(maxNumber);
			} while (pairsTable.contains(elem));
			pairsTable.add(elem);
		}
		for (int e : pairsTable) {
			int i,j;
			for (int k=0; k < 2; k++) {
				do {
					i = random.nextInt(width);
					j = random.nextInt(width);
					System.out.println("doloop");
				} while (gameTable[i][j] >= 0);
				gameTable[i][j] = e;
			}
			
		}
		
	}
	
	public boolean openButton(int i, int j) {
		if (currentValue < 0) {
			currentValue = gameTable[i][j];
			return false;
		} else {
			if (currentValue == gameTable[i][j]) {
				openedCounter++;
				if(openedCounter == width*width/2) {
					gameWon = true;
				}
				currentValue = -1;
				return true;
			} else {
				currentValue = -1;
				return false;
			}
		}	
	}
	
	public boolean gameIsWon() {
		return gameWon;
	}
	
	public int getElement(int i, int j) {
		return gameTable[i][j];
	}
}
