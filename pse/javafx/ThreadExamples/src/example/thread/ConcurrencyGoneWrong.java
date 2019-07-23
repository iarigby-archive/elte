package example.thread;

public class ConcurrencyGoneWrong {
    
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    counter++;
                }
            }
        });
        t.start();

        for (int i = 0; i < 1_000_000; i++) {
            counter--;
        }
        t.join();

        System.out.println(counter);
    }
}


