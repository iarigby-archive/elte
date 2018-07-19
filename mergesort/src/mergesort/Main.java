package mergesort;

public class Main {
	
	public static void main(String[] args) {
		int[] array = {4,6,1,3,8,32,67,213,3};
		System.out.println("test");
		mergeSort(array);
		toString(array);
	}
	
	public static void mergeSort(int[] array) {
		if (array.length > 1) {
			System.out.println("Sort" );
			toString(array);
			int n = array.length/2;
			int[] n1 = new int[n];
			int[] n2 = new int[n];
			for (int i = 0; i < n; i++) n1[i] = array[i];
			for (int i = 0; i < n; i++) n2[i] = array[n+i];
			toString(n1);
			toString(n2);
			mergeSort(n1);
			mergeSort(n2);
			int i = 0;
			int j = 0;
			for (int k = 0; k < array.length; k++) {
				System.out.println(k + " " + i + " "+ j);
				if (i < n1.length) {
					toString(n1);
					toString(n2);
					if (n1[i] >= n2[j]) {
						array[k] = n1[i];
						i++;
					} else {
						array[k] = n1[j];
						j++;
					}
				} else {
					array[k] = n1[j];
					j++;
				}
				
			}	
		}
	}
	
	public static void toString(int[] array) {
		for (int element : array) System.out.print(element + ", ");
		System.out.println();
	}

}
