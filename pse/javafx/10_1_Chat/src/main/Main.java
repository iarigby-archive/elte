package main;

import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Server;

public class Main {

    public static void main(String[] args) {

    	Server server = new Server(3);
        Client john = new Client(server, "John", 3);
        Client jane = new Client(server, "Jane", 100);
        Client tom = new Client(server, "Tom", 100);
        Client anne = new Client(server, "Anne", 10);

        List<Thread> clients = new ArrayList<>();
        clients.add(new Thread(john));
        clients.add(new Thread(jane));
        clients.add(new Thread(tom));
        clients.add(new Thread(anne));

        Thread serverThread = startAllThreads(server, clients);

        john.send("Hi everybody");
        jane.send("Hi John!");
        tom.send("Hello");
        anne.send("Is everybody here?!");

        makeMainSleepForDemo();
        stoppingThreads(serverThread, clients);

        System.out.println("Simulation ended");
    }

    static Thread startAllThreads(Server server, List<Thread> clients) {
        Thread serverThread = new Thread(server);
        serverThread.start();
        clients.forEach(Thread::start);
        return serverThread;
    }

    static void makeMainSleepForDemo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void stoppingThreads(Thread serverThread, List<Thread> clients) {
        try {
            serverThread.interrupt();
            serverThread.join();
            for (Thread c : clients) {
                c.interrupt();
                c.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
