package chap06.QuickSort;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int data[] = { 69, 10, 30, 2, 16, 8, 31, 22 ,10,10,10,22,33,16,100,1,1,-2,50,23,23,23,1,-2};
		
		int data2[] = data.clone();
		
		
		System.out.println("- 최 좌측 pivot 정렬 전: "+ Arrays.toString(data));
		QuickSort.quickSort(data, 0, data.length - 1); 
		System.out.println("- 최 좌측 pivot 정렬 후: "+ Arrays.toString(data));

		System.out.println();
        
		System.out.println("- 개선된 pivot 정렬 전: "+ Arrays.toString(data2));
        ImprovedPivotQuickSort.sort(data2, 0, data.length - 1);
        System.out.println("- 개선된 pivot 정렬 후: "+ Arrays.toString(data2));

	}

}
