package Trigonacci;

public class Trigonacci {
	
	public int T(int n) {
		if (n == 1) {
			return 0;
		}
		else if (n==2) {
			return 0;
		}
		else if (n==3) {
			return 1;
		}
		else {
			return T(n-3) + T(n-2) + T(n-1);
		}
	}
	
	public static void main(String args[]) {
		Trigonacci t = new Trigonacci();
		if (args.length == 1) {
			System.out.println(t.T(Integer.parseInt(args[0])));
		} else {
			System.err.println("error, enter one argument");
		}
	
	}
}
