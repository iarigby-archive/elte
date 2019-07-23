package example.thread;

public class ConcurrencyDoneRightAndSlow {

    private static Object monitor = new Object();
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (monitor) {
                    counter++;
                }
            }
        });
        t.start();

        for (int i = 0; i < 1_000_000; i++) {
            synchronized (monitor) {
                counter--;
            }
        }
        t.join();

        System.out.println(counter);
    }
}

