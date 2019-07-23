package model;

public class Worker implements Runnable {

	private final ConcurrentQueue<ExponentialData> input;
	private final ConcurrentQueue<ExponentialData> output;

	public Worker(ConcurrentQueue<ExponentialData> input, boolean isLast) {
		this.input = input;
		this.output = isLast ? null : new ConcurrentQueue<>(2); // low capacity, threads maybe will have to wait
	}

	@Override
	public void run() {
		ExponentialData data = null;
		do {
			try {
				data = input.dequeue();
				if (data == null) { // if the thread reaches this block, it will shutdown
					if (!isLast()) {
						output.enqueue(data);
					}
				} else {
					double x = data.getX();
					long k = data.getK() + 1;
					double xPowK = data.getxPowK() * x;
					long kFactor = data.getkFactor() * k;
					double sum = data.getSum() + (xPowK / kFactor);
					ExponentialData nextData = new ExponentialData(x, k, xPowK, kFactor, sum);
					if (isLast()) {
						System.out.println(nextData);
					} else {
						output.enqueue(nextData);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (data != null);
		System.out.println(Thread.currentThread().getName() + ": done");
	}

	public ConcurrentQueue<ExponentialData> getOutput() {
		return output;
	}

	private boolean isLast() {
		return output == null;
	}

}
