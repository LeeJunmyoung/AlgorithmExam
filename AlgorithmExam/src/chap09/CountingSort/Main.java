package chap09.CountingSort;

import java.util.Arrays;

public class Main {

	public static void main(String [] args){
		
		CountSort countSort = new CountSort(10);
		int data[] ={9,4,3,1,7,8,9,4,6,1,5,5,5,5};
		System.out.println("정렬 전 : "+ Arrays.toString(data));
		
		System.out.println("정렬후  : "+ Arrays.toString(countSort.sortCounting(data)));
		
	}
	
}
