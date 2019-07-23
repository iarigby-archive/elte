package main;

import service.DooredRoomDecorator;
import service.WindowedRoomDecorator;
import service.base.Kitchen;
import service.base.LivingRoom;
import service.base.Person;
import service.base.Room;
import service.new_component.Door;
import service.new_component.Window;

public class Main {

    public static void main(String[] args) {
        Person johnDoe = new Person("John Doe");
        
        LivingRoom johnsLivingRoom = new LivingRoom(johnDoe);
        drawRoom(johnsLivingRoom);

        DooredRoomDecorator johnsLivingRoomWithDoor = new DooredRoomDecorator(johnsLivingRoom, new Door(210, 150));
        drawRoom(johnsLivingRoomWithDoor);

        Window window = new Window(120, 210);
        
        WindowedRoomDecorator johnsLivingRoomWithWindow = new WindowedRoomDecorator(johnsLivingRoom, window);
        drawRoom(johnsLivingRoomWithWindow);

        WindowedRoomDecorator johnsLivingRoomWithDoorAndWindow = new WindowedRoomDecorator(johnsLivingRoomWithDoor, window);
        drawRoom(johnsLivingRoomWithDoorAndWindow);

        Kitchen kitchen = new Kitchen();
        drawRoom(kitchen);

        WindowedRoomDecorator kitchenWithWindow = new WindowedRoomDecorator(kitchen, window);
        drawRoom(kitchenWithWindow);
    }

    private static void drawRoom(Room room) {
        System.out.println("<room>");
        room.draw();
        System.out.println("</room>\n");
    }

}
