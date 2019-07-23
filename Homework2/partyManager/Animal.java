package partyManager;

public abstract class Animal {

	private String name;
	private Specie specie;
	
	public Animal(String name, Specie specie) {
		this.name = name;
		this.specie = specie;
	}

	public String getName() { return name;} 
	public Specie getSpecie() {return specie;}

}