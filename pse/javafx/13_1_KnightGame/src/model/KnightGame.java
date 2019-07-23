package model;

import java.util.Arrays;

public class KnightGame {

	
	private Coordinate currentCoordinate;
	private boolean[][] hasStepped;
	private final Coordinate startingPosition = new Coordinate(0,0);
	private int size;
	private int stepsCount;
	
	public KnightGame(int size) {
		hasStepped = new boolean[size][size];
		this.size = size;
		for (boolean[] row : hasStepped) 
			Arrays.fill(row, false);			
		currentCoordinate = startingPosition;
		//setHasStepped(currentCoordinate);
		stepsCount = 0;
	}
	
	public boolean nextStep(Coordinate coordinate) {
		if (isValidMove(coordinate)) {
			currentCoordinate = coordinate;
			setHasStepped(coordinate);
			stepsCount++;
			return true;
		}
		return false;
	}
	
	public boolean isValidMove(Coordinate coordinate) {
		int rowDifference = coordinate.x - currentCoordinate.x;
		int columnDifference = coordinate.y - currentCoordinate.y;
		return rowDifference*rowDifference + columnDifference*columnDifference == 5;
	}
	
	public boolean isValidIndex(int i, int j) {
		return i >=0 && i < size && j >= 0 && j < size;
		
	}
	
	public boolean isGameWon() {
		return stepsCount == size*size-1;
	}
	
	public boolean isStuck() {
		Coordinate coordinate = new Coordinate();
		for (int i = currentCoordinate.x - 2; i <= currentCoordinate.x + 2; i++) {
			for (int j = currentCoordinate.y - 2; j <= currentCoordinate.y + 2; j++) {
				coordinate.set(i, j);
				if (i != currentCoordinate.x && j != currentCoordinate.y) {
					if (isValidIndex(i,j) && isValidMove(coordinate)) {
						if (!hasStepped[i][j]) {
							return false;
						}
					}
				}
			}
		}
		return false;
	}
	
	public int getStepsCount() { return stepsCount;}
	
	public void setHasStepped(Coordinate coordinate) {
		hasStepped[coordinate.x][coordinate.y] = true;
	}
	
	public Coordinate getLocation() {return currentCoordinate;}
	
	public int getNodeIndex() { return currentCoordinate.x + currentCoordinate.y*size; }
	
	public int getSize() { return size; }
}
