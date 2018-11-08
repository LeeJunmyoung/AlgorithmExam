package chap09.CountingSort;

import java.util.Arrays;

public class CountSort {

	int countData[];

	public CountSort(int size) {
		countData = new int[size ];
		Arrays.fill(countData, 0);
	}

	public int[] sortCounting(int[] arrData) {
		int [] sortedData = new int[arrData.length];
		/*
		 * 1. 들어간 숫자 세기
		 * 2. 배열 동일하게 하나 추가
		 * 3. 배열 수 누적합
		 * 4. 기존 배열의 끝에서부터 누적합 위치 참조해서 넣어주고 누적합 -1 해주기
		 */
		
		for(int i=0; i<arrData.length; i++) {
			countData[arrData[i]]++;
		}
		
		for(int i=1; i<countData.length; i++) {
			countData[i] = countData[i-1]+countData[i];
		}
		
		
		for(int i=0; i<arrData.length; i++) {
			sortedData[ countData[arrData[i]] - 1] = arrData[i];
			countData[arrData[i]]--;
		}
		
		return sortedData;
	}

}
