package service.base;

public class LivingRoom implements Room {

	private Person owner;
	
	public LivingRoom(Person owner) {
		this.owner = owner;
	}
	
	public void draw() {
		System.out.println("This is a living room that belongs to " + owner);
	}
}
