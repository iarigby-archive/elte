package main;

import model.ConcurrentQueue;
import model.ExponentialData;
import model.Worker;

public class Main {

    public static final int NUM_OF_INPUTS = 10;
    public static final int NUM_OF_WORKERS = 20;

    public static void main(String[] args) {
        ConcurrentQueue<ExponentialData> userInputQueue = new ConcurrentQueue<>(NUM_OF_INPUTS);
        Thread[] workers = new Thread[NUM_OF_WORKERS];

        try {
            settingUpThreads(userInputQueue, workers);
            startingThreads(workers);
            releasingInputs(userInputQueue);
            waitingThreadsToComplete(workers);
            System.out.println("Task is done, threads completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void settingUpThreads(ConcurrentQueue<ExponentialData> queue, Thread[] workers) {
        Worker first = new Worker(queue, false);
        workers[0] = new Thread(first);
        ConcurrentQueue<ExponentialData> outputOfPrevThread = first.getOutput();
        for (int i = 2; i <= NUM_OF_WORKERS; i++) {
            Worker w = new Worker(outputOfPrevThread, i == NUM_OF_WORKERS);
            workers[i - 1] = new Thread(w);
            outputOfPrevThread = w.getOutput();
        }
    }

    private static void startingThreads(Thread[] workers) {
        for (Thread t : workers) {
            t.start();
        }
    }

    private static void releasingInputs(ConcurrentQueue<ExponentialData> userInputQueue) throws InterruptedException {
        for (int i = 1; i <= NUM_OF_INPUTS; i++) {
            userInputQueue.enqueue(new ExponentialData(i));
        }
        userInputQueue.enqueue(null);
    }

    private static void waitingThreadsToComplete(Thread[] workers) throws InterruptedException {
        for (Thread t : workers) {
            t.join();
        }
    }
}
