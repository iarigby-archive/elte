package service;
import service.new_component.*;
import service.base.*;

public class DooredRoomDecorator extends RoomDecorator{
	private Door door;
	
	public DooredRoomDecorator(Room room, Door door) {
		this.room = room;
		this.door = door;
	}
	
	public void draw() {
		room.draw();
		System.out.println(door.getHeight() + " " + door.getWidth());
	}
}
