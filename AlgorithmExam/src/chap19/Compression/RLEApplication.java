package chap19.Compression;

public class RLEApplication {

	
	public static void main(String[] args) {
		String text = "AAAAAAAAAAAAAAABBDDDCCDDED";
		
		String encodeText= RunLengthEncoding.encode(text);
		String decodeText= RunLengthEncoding.decode(encodeText);
		System.out.println(encodeText);
		System.out.println(decodeText);
		System.out.println(text.equals(decodeText));
		
		
		System.out.println();
		
		
		String encodeText2= RunLengthEncoding.encode2(text);
		String decodeText2= RunLengthEncoding.decode2(encodeText2);
		System.out.println(encodeText2);
		System.out.println(decodeText2);
		System.out.println(text.equals(decodeText2));
	}
}


class RunLengthEncoding{
	public static String encode(String source) {
		StringBuilder dest = new StringBuilder();
	    for (int i = 0; i < source.length(); i++) {
	        int runLength = 1;
	        while (i+1 < source.length() && source.charAt(i) == source.charAt(i+1)) {
	            runLength++;
	            i++;
	        }
	        if(runLength!=1)
	        dest.append(runLength);
	        dest.append(source.charAt(i));
	    }
	    return dest.toString();
	}
	
	public static String decode(String encoding) {
		StringBuilder dest = new StringBuilder();
	    for (int i = 0; i < encoding.length(); i++) {
	    	StringBuilder countStr=new StringBuilder();
	        while (i+1 < encoding.length() 
	        		&& Character.isDigit(encoding.charAt(i))) {
	        	countStr.append(encoding.charAt(i));
	            i++;
	        }
	        int count = countStr.toString().equals("")?1:Integer.parseInt(countStr.toString());
	        for(int num=0;num<count;num++)
	        dest.append(encoding.charAt(i));
	    }
	    return dest.toString();
    }
	
	public static String encode2(String source) {
		StringBuilder dest = new StringBuilder();
	    for (int i = 0; i < source.length(); i++) {
	        int runLength = 1;
	        while (i+1 < source.length() && source.charAt(i) == source.charAt(i+1)) {
	            runLength++;
	            i++;
	        }
	        
	        dest.append(source.charAt(i));
	        if(runLength!=1)
		        dest.append(runLength);
	    }
	    return dest.toString();
	}
	
	public static String decode2(String encoding) {
		StringBuilder dest = new StringBuilder();
		int i =0;
	    while(i<encoding.length()){
	    	char c = 0;
	    	if(!Character.isDigit(encoding.charAt(i))){
	    		c=encoding.charAt(i);
	    		i++;
	    	}
	    	
	    	StringBuilder countStr=new StringBuilder();
	        while (i+1 < encoding.length() 
	        		&& Character.isDigit(encoding.charAt(i))) {
	        	countStr.append(encoding.charAt(i));
	            i++;
	        }
	        int count = countStr.toString().equals("")?1:Integer.parseInt(countStr.toString());
	        for(int num=0;num<count;num++)
	        dest.append(c);
	    }
	    return dest.toString();
    }
}
