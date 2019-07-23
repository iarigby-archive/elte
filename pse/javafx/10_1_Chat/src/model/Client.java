package model;

public class Client  implements Runnable {
	private String name;
	private int disconnectionAfter;
	private ConcurrentQueue<Message> messages;
	private Server server;
	
	public Client(Server server, String name, int disconnectionAfter) {
		this.disconnectionAfter = disconnectionAfter;
		this.name = name;
		server.connect(this);
		this.server = server;
		this.messages = new ConcurrentQueue<>(disconnectionAfter);
	}
	
	@Override
	public void run() {
		boolean running = true;
		Message msg = null;
		while (running) {
			if(Thread.interrupted()) {
				running = false;
			} else {
				try {
					msg = messages.dequeue();
					if(msg == null) {
						
					} else {
						Display.show(msg, name);
					}
				} catch (InterruptedException e) {
					running = false;
				}
			}
		}
	}
	
	public void send(String message) {
		server.broadcast(new Message(name, message));
	}
	
	
	public void receive(Message msg) {
		try {
			messages.enqueue(msg);
		} catch (InterruptedException e) {
			server.disconnect(this);
		}
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getDisconnectionAfter() {
		return disconnectionAfter;
	}
}
