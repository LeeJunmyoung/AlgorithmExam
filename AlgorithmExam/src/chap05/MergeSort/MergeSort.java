package chap05.MergeSort;

public class MergeSort {

	static public void mergeSort(int data[] , int indexP,int indexR){
		
		if(indexP<indexR){
			int indexQ = (indexP + indexR)/2;
			
			mergeSort(data, indexP,indexQ);
			mergeSort(data, indexQ+1, indexR);
			merge(data,indexP,indexQ,indexR);
			
		}
		
		
	}

	private static void merge(int[] data, int indexP, int indexQ, int indexR) {
		// TODO Auto-generated method stub
		int i=indexP,j=indexQ+1,k=indexP;
		
		int tmp[] = new int[data.length]; //배열의 크기만큼 생성
		
		while(i<=indexQ&&j<=indexR){ //i <= 중간 인덱스 && 중간 인덱스 <=끝 인덱스
			if(data[i]<=data[j]){
				tmp[k++]=data[i++];
			}else{
				tmp[k++]=data[j++];
			}
		}
		
		//인덱스가 종료되면 남아있는 인덱스를 다 복사
		while (i<=indexQ){
			tmp[k++]=data[i++];
		}
		while (j<=indexR){
			tmp[k++]=data[j++];
		}
		
		// data에 합병 절렬된 값을 저장.
		for(int x=indexP;x<=indexR;x++){
			data[x]=tmp[x];
		}
		
	}
	
	
}
