package chap05.MergeSort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]={1,6,90,50,200,5,6,200};
		MergeSort.mergeSort(data, 0,data.length-1);
		System.out.println(Arrays.toString(data));
	}

}
