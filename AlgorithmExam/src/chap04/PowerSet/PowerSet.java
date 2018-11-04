package chap04.PowerSet;

public class PowerSet {

	public static char data[] = {'a','b','c','d','e'};
	public static final int N = data.length;
	public static boolean includes[] = new boolean[N];
			
	public static void powerSet(int k) {
		if(k==N) {
			for(int i=0; i<k; i++) {
				if(includes[i]) {
					System.out.print(data[i] + " ");
				}
			}
			System.out.println();
			return;
		}else {
			includes[k] = false;
			powerSet(k+1);
			includes[k] = true;
			powerSet(k+1);
		}
	}
	
}
