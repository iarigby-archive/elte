package model;

public class Client implements Runnable {
    
    private final String name;
    private final Server server;
    private final ConcurrentQueue<Message> queue;
    private int disconnectionAfter;

    public Client(Server server, String name, int disconnectionAfter) {
        this.name = name;
        this.server = server;
        this.queue = new ConcurrentQueue<>(3);
        this.disconnectionAfter = disconnectionAfter;
        server.connect(this);
    }

    public void send(String txt) {
        Message msg = new Message(name, txt);
        server.broadcast(msg);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && disconnectionAfter > 0) {
            try {
                Message msg = queue.dequeue();
                Display.show(msg, name);
                disconnectionAfter--;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        server.disconnect(this);
    }

    public void receive(Message msg) {
        try {
            queue.enqueue(msg);
        } catch (InterruptedException e) {
        	Thread.currentThread().interrupt();
        }
    }

    public String getName() {
        return name;
    }
}
