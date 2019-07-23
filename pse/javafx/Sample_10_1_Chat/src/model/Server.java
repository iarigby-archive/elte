package model;

import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {
    
    private final List<Client> clients = new ArrayList<>();
    private final ConcurrentQueue<Message> messages;

    public Server(int throughput) {
        messages = new ConcurrentQueue<>(throughput);
    }

    public synchronized void connect(Client client) {
        clients.add(client);
    }

    public void disconnect(Client client) {
        synchronized (this) {
            clients.remove(client);
        }
        try {
            messages.enqueue(new Message("Server", client.getName() + " disconnected..."));
        } catch (InterruptedException e) {
        }
    }

    public void broadcast(Message msg) {
        try {
            messages.enqueue(msg);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Message msg = messages.dequeue();
                synchronized (this) {
                    for (Client c : clients) {
                        c.receive(msg);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
