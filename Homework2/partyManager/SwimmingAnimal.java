package partyManager;

public class SwimmingAnimal extends Animal {
	
	public String comesFrom;

	public SwimmingAnimal(String name, Specie specie, String comesFrom) {
		super(name, specie);
		this.comesFrom = comesFrom;
	}

}