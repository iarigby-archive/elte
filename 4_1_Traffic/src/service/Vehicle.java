package service;

abstract class Vehicle {
	private final String name;
	private final double consumption;
	private double fuel;
	
	
	public Vehicle(String name, double c, double f) {
		this.name = name;
		this.consumption = c;
		this.fuel = f;
	}
	
	abstract long getRefreshInterval();
	
	public void start() {
	    new Thread(() -> {
	        String type = getClass().getName().toUpperCase();
	        long refreshInterval = getRefreshInterval();
	        while (fuel > 0.0) {
	            printInfo(type + "(" + name + "): " + fuel);
	            fuel -= consumption;
	            try {
	                Thread.sleep(refreshInterval);
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
	        }
	        printInfo(type + "(" + name + ") has been stalled");
	    }).start();
	}

	public static synchronized void printInfo(String info) {
	    System.out.println(info);
	}
}
