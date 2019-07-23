package model;

public class ExponentialData {
	// this type is immutable:
	// https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html

	private double x;
	private long k;
	private double xPowK;
	private long kFactor;
	private double sum;

	public ExponentialData(double x) {
		this(x, 0, 1, 1, 1);
	}

	public ExponentialData(double x, long k, double xPowK, long kFactor, double sum) {
		this.x = x;
		this.k = k;
		this.xPowK = xPowK;
		this.kFactor = kFactor;
		this.sum = sum;
	}

	public double getX() {
		return x;
	}

	public long getK() {
		return k;
	}

	public double getxPowK() {
		return xPowK;
	}

	public long getkFactor() {
		return kFactor;
	}

	public double getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return "exp(" + x + ") = " + sum + "\t[k=" + k + ", x^k=" + xPowK + ", k!=" + kFactor + "]";
	}

}