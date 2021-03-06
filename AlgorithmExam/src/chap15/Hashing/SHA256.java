package chap15.Hashing;

import java.security.MessageDigest;

public class SHA256 {
		
	
	//검증 https://www.xorbin.com/tools/sha256-hash-calculator
	 public static void main(String[] args) {
		 
	        String base = "1234";
	 
	        try{
	 
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(base.getBytes("UTF-8"));
	            StringBuffer hexString = new StringBuffer();
	 
	            for (int i = 0; i < hash.length; i++) {
	                String hex = Integer.toHexString(0xff & hash[i]);
	                if(hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	 
	            //출력
	            System.out.println(hexString.toString());
	 
	        } catch(Exception ex){
	            throw new RuntimeException(ex);
	        }
	 
	    }
	
}
