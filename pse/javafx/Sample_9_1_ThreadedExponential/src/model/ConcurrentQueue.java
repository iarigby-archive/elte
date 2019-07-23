package model;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentQueue<T> {

    private final List<T> queue;
    private final int capacity;

    public ConcurrentQueue(int capacity) {
        this.queue = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public synchronized void enqueue(T elem) throws InterruptedException {
        while (queue.size() >= capacity) {
            wait();
        }
        queue.add(elem);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T elem = queue.remove(0);
        notifyAll();
        return elem;
    }
}
