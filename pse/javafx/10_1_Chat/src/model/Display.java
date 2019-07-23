package model;

public class Display {
	public synchronized static void show(Message msg, String recipient) {
		System.out.println(msg.getSender() + ": " + msg.getMsg() + "\n\t seen by " + recipient);
	}
}
