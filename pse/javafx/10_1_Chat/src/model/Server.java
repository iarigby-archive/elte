package model;

import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {
	private int throughtput;
	private ConcurrentQueue<Message> messages;
	private List<Client> clients = new ArrayList<Client>();
	
	public Server(int throughput) {
		this.throughtput = throughput;
		messages = new ConcurrentQueue<>(throughtput);
	}
	
	@Override
	public void run() {
		boolean running = true;
		while (running) {
			if(Thread.interrupted()) {
				running = false;
			} else {
				try {
					Message msg = messages.dequeue();
					if(msg == null) {
					
					} else {
						clients.forEach(client -> client.receive(msg));
					}
				} catch (InterruptedException e) {
					running = false;
				}
			}
			
		} 
		
	}
	
	public void connect(Client client) {
		clients.add(client);
	}
	
	public void disconnect(Client client) {
		clients.remove(client);
	}
	
	public void broadcast(Message msg) {
		try {
			messages.enqueue(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
