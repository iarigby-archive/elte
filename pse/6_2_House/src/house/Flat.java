package house;

import java.util.*;

public class Flat {
	public int flatNumber;
	
	private ArrayList<Flat> neighbors = new ArrayList<Flat>();
	
	
	public Flat(int n) {
		flatNumber = n;
	}
	
	public void validate() {
		
	}
	
	public void addNeighbour(Flat flat) { neighbors.add(flat); }
	
	public int numberOfNeighbours() {return neighbors.size();}
	public Flat getFirstNeighbour() {return neighbors.get(0);}
	public Flat getSecondNeighhour() {return neighbors.get(1);}
	
	
	
}
