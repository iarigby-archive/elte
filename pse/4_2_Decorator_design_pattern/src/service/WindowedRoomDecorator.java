package service;
import service.base.Room;
import service.new_component.*;


public class WindowedRoomDecorator extends RoomDecorator{

	private Window window;
	
	public WindowedRoomDecorator(Room room, Window window) {
		this.room = room;
		this.window = window;
	}
	
	public void draw() {
		room.draw();
		System.out.println(window.getHeight() + " " + window.getWidth());
	}
}
