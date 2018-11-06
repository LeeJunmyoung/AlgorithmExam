package chap06.QuickSort;

public class QuickSort {
	public static int partition(int arr[], int left, int right)
	{
	    int pivot = left; // 피벗의 위치는 가장 왼쪽에서 시작
	    int low = left;
	    int high = right;
	    int temp;
	    while (low < high) // 교차되기 전까지 반복한다 
	    {
	        while (arr[pivot] >= arr[low] && low <= right) // 피벗보다 큰 값을 찾는 과정 
	        {
	            low++; // low를 오른쪽으로 이동 
	        }
	        while (arr[pivot] <= arr[high] && high >= (left+1) ) // 피벗보다 작은 값을 찾는 과정 
	        {
	            high--; // high를 왼쪽으로 이동
	        }
	        if (low <= high)// 교차되지 않은 상태이면 스왑 과정 실행 
	        {
	        	temp=arr[low];
	        	arr[low]=arr[high];
	        	arr[high]=temp;
	        }
	    }
	    temp =arr[pivot];
	    arr[pivot]=arr[high];
	    arr[high]=temp;
	     
	    return high;  // 옮겨진 피벗의 위치정보를 반환 
	 
	}

	public static void quickSort(int arr[], int left, int right) {

		if (left < right) {

			int pivotNewIndex = partition(arr, left, right);

			quickSort(arr, left, pivotNewIndex-1);
			quickSort(arr, pivotNewIndex + 1, right);
		}

	}

}
