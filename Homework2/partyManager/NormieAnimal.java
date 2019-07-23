package partyManager;

public class NormieAnimal extends Animal {
	int numberOfPaws;

	public NormieAnimal(String name, Specie specie, int numberOfPaws) {
		super(name, specie);
		this.numberOfPaws = numberOfPaws;
	}
}