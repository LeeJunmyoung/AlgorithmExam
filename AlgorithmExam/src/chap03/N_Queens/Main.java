package chap03.N_Queens;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (short n = 1; n < 14; n++) {
			NQueenCounting.enumerate(n);
            System.out.println("n = " + (n < 10 ? "0" : "") + n + ", solution count is " + NQueenCounting.count + ".");
            NQueenCounting.count = 0;
        }
		
		for (short n = 0; n < 14; n++) {
			NQueen nQueen = new NQueen(n);
			nQueen.queens(0);
        }
	}

}
