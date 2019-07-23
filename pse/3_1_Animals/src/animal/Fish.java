package animal;
import animal.food.*;

public class Fish extends Animal implements Food {
	
	public Fish() {
		super("fishey");
	}
	
	public String toString() {
		return "delicious fish sticks";
	}
}
