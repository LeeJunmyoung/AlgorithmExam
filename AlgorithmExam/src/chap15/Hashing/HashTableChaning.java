package chap15.Hashing;

import java.math.BigDecimal;


public class Hash {
	
	public static void main(String [] args) throws CloneNotSupportedException{
		Hash hash = new Hash(10);
		
		hash.add("CLRS");
		hash.add("ABCD");
		hash.add("1234");
		hash.add("9");
		
		hash.getKey(7);
		
		hash.remove("9");
		
		hash.getKey(7);
	}
	
    
    // Data
    private class Data implements Cloneable {
        private String value;
        public Data next; //chaining 을 위한 다음값.
        
        Data(String _value){
        	this.value=_value;
        }
        
        
        public Object clone() throws CloneNotSupportedException {
        	Data a = (Data)super.clone();
        	return a;
        }
    }
    
    private int size;
    private Data[] dataTable;
    
    // size 설정
    public Hash(int size){
        this.size = size;
        this.dataTable = new Data[size];
    }
    
    // key 값으로 HashTable에 저장될 index를 반환한다.
    public int hashMethod(String data){
    	char [] cArr = data.toCharArray();
    	BigDecimal sum = new BigDecimal(0);
    	int count=0;
    	for(int num = cArr.length-1; num>=0 ; num--){
    		
    		int indexChartoInt = (int)cArr[num];
    		BigDecimal addInteger = new BigDecimal(indexChartoInt);
    		BigDecimal bit128MultiInt =  bitMultiply(count);
    		//System.out.println(addInteger + " * " +bit128MultiInt);
    		addInteger= addInteger.multiply(bit128MultiInt);
    		
    		sum=sum.add(addInteger);
    		count++;
    	}
    	//System.out.println(sum.intValue());
    	
        return sum.remainder(new BigDecimal(size))
        		.toBigInteger()
        		.intValue();
    }
    
    //문자열을 각자리에 128 ^ x 로 연산하기 위한 메서드
    public BigDecimal bitMultiply(int num){
    	BigDecimal bitMultiInt = new BigDecimal(1);
    	if(num==0){
    		return bitMultiInt;
    	}else{
    		for(int a=0; a<num;a++){
    			bitMultiInt=bitMultiInt.multiply(new BigDecimal(128));
    		}
    	}
    	return bitMultiInt;
    }
    
 // data를 HashTable에 저장한다.
    public void add(String data){
    	int hash = hashMethod(data);
    	
    	Data addData =new Data(data);
    	if(dataTable[hash]==null){
    		dataTable[hash]= addData;
    	}else{
    		Data beforeData = dataTable[hash];
    		addData.next = beforeData;
    		dataTable[hash] = addData;
    	}
    }
    
    
    // key 에 가지고 있는 값들을 모두 조회
    public void getKey(int hash) throws CloneNotSupportedException{
    	Data hashData = dataTable[hash];
    	Data cloneData = (Data) hashData.clone();
    	System.out.println("==========GET KEY("+hash+")========");
    	
    	while(cloneData!=null){
    		System.out.println(cloneData.value);
    		cloneData = cloneData.next;
    	}
    	
    	System.out.println("==========GET KEY("+hash+")========");
    	
    }
    
    
    
    // data 를 제거
    public void remove(String data){
    	int hash = hashMethod(data);
    	Data hashData = dataTable[hash];
    	while(hashData.next!=null){
    		if(hashData.value.equals(data)){
    			hashData.next=hashData.next.next;
    		}
    	}
    }
    
}

