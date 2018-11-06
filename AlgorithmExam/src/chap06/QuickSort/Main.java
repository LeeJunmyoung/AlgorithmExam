package chap06.QuickSort;

public class Main {
	public static void main(String[] args) {

		int[] arrs = { 69, 10, 30, 2, 16, 8, 31, 22 ,10,10,10,22,33,16,100,1};
		QuickSort.quickSort(arrs, 0, arrs.length - 1); 
		
		System.out.println("결과");

		for (int i : arrs) {
			System.out.print(i + " ");
		}

	}

}
