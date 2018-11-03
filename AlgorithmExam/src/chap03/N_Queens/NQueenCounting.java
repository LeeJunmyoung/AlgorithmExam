package chap03.N_Queens;

public class NQueenCounting {
		
	static int count = 0;
    public static boolean isPromising(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) return false;  //정방향
            if ((q[i] - q[n]) == (n - i)) return false; //  오른쪽대각
            if ((q[n] - q[i]) == (n - i)) return false;  // 왼쪽 대각
        }
        return true;
    }

    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int n) {
        int N = q.length;
        
        if (n == N) {
            count++;
        } else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isPromising(q, n)) enumerate(q, n + 1);  
            }
        }
    }
}
