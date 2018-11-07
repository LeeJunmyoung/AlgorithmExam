package chap07.HeapSort;

public class HeapSort {

	private static void heapify(int arr[], int length, int i) {
		
        int left = 2*i + 1;
        int right = 2*i + 2;
        int temp, largest = i;
        
        
        if( left<length && arr[left]>arr[largest]) largest = left;
        
        if( right<length && arr[right]>arr[largest]) largest = right;
        
        if( largest != i ) {
            temp = arr[i];
            arr[i] = arr[largest]; 
            arr[largest] = temp;
            heapify(arr, length, largest);
        }
        
    }
	
	
    public static void heapSort(int arr[]) {
        int i, temp, length = arr.length;
        
        for(i=length/2; i>=0; i--){
        	heapify(arr, length, i);
        }
        
        for(i=length-1; i>=0; i--) {
            temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
	
	



}
