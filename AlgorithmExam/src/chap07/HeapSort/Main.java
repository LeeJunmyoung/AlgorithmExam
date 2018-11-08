package chap07.HeapSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[51] ;
		for(int num=0;num<51;num++)
		arr[num]= new Random().nextInt(500);
		
		System.out.println("정렬 전 : "+ Arrays.toString(arr));
		
		HeapSort.heapSort(arr);
        
		System.out.println("정렬 후 : "+ Arrays.toString(arr)); 
	}

}
