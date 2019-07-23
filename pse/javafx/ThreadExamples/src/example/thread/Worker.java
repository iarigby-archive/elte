package example.thread;

import java.util.ArrayList;
import java.util.List;

public class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello ");
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            threads.add(new Thread(new Worker()));
        }
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("world!");
    }

}
