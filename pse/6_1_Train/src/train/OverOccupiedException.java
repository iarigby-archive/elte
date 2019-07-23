package train;

public class OverOccupiedException extends Exception {
	private Wagon wagon;
	
	public OverOccupiedException(Wagon w) {
		this.wagon = wagon;
	}
	
	public Wagon getWagon() {return wagon;}
}
