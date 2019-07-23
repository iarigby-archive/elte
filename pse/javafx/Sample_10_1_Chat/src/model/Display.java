package model;

public class Display {

    public static synchronized void show(Message msg, String recipient) {
        System.out.println(msg.getSender() + ": " + msg.getMsg() + " @" + recipient);
    }

}
