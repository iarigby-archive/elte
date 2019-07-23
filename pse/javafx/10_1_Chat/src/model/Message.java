package model;

public class Message {
	private String sender;
	private String msg;
	
	public Message(String sender, String msg) {
		this.sender = sender;
		this.msg = msg;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getMsg() {
		return msg;
	}
}
