package chap10.RadixSort;

import java.util.LinkedList;
import java.util.Random;

public class Main {

	
	 
	  /**
	   * Main method.
	   * @param args
	   */
	  public static void main(String[] args)
	  {
		  
		RadixSort radix = new RadixSort();  
	    // Random List.
	    Object[] list = new Object[100];
	 
	    // Generate a random list of numbers.
	    for(int r=0; r < list.length; r++){
	      list[r] = new Random().nextInt(1000 * 1000);
	    }
	 
	    // Sort the list.
	    Object[] sortedList = radix.sort(list);
	 
	    // Print the sorted list.
	    for(int i=0; i < sortedList.length; i++){
	      System.out.println(sortedList[i]);
	    }
	 
	  }
	
	
}
