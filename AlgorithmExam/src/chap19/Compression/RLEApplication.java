package chap19.Compression;

public class RLEApplication {

	
	public static void main(String[] args) {
		String text = "AAAAAAAAAAAAAAABBDDDCCDDED";
		
		
		System.out.println(RunLengthEncoding.encode(text));
		System.out.println(RunLengthEncoding.decode(text));
		System.out.println(text);
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
}
