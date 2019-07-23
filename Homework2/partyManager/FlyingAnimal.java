package partyManager;

public class FlyingAnimal extends Animal {
	
	public int wingExtension;

	public FlyingAnimal(String name, Specie specie, int wingExtension) {
		super(name, specie);
		this.wingExtension = wingExtension;
	}
	
}