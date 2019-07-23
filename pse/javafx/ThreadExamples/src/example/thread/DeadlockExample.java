package example.thread;

public class DeadlockExample {

	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
			bower.bowBack(this);
		}

		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Friend tamas = new Friend("Tamas");
		Friend istvan = new Friend("Istvan");
		Thread t1 = new Thread(() -> tamas.bow(istvan));
		Thread t2 = new Thread(() -> istvan.bow(tamas));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
