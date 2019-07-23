package train;

public class Locomotive {
	private String brand;
	private String type;
	
	public Locomotive(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return brand + " " + type;
	}
	
	public String getBrand() {return brand;}
	public String getType() {return type;}
}
