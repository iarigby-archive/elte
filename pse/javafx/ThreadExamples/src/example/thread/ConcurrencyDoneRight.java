package example.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyDoneRight {
	private static AtomicInteger counter = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 1_000_000; i++) {
				counter.incrementAndGet();
			}
		});
		t.start();

		for (int i = 0; i < 1_000_000; i++) {
			counter.decrementAndGet();
		}
		t.join();

		System.out.println(counter);
	}
}
