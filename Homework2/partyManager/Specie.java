package partyManager;

public enum Specie {
	TURTLE(AnimalType.WATER, "water tank"),
	HAWK(AnimalType.AIR, "Freedom"),
	GIRAFFE(AnimalType.LAND, "Necklace"),
	PANTHER(AnimalType.LAND, "Something Pink"),
	RABBIT(AnimalType.LAND, "Carrots");

	private final AnimalType animalType;
	private final String need;

	Specie(AnimalType animalType, String need) {
		this.animalType = animalType;
		this.need = need;
	}

	public String getNeed() {
		return need;
	}

	public AnimalType getType() {
		return animalType;
	}

	public static String getList() {
		String result = "";
		int i = 1;
		for (Specie specie : Specie.values()) {
			result += i + ". " + specie.name() + "\n";
			i++;
		}
		return result;
	}
}