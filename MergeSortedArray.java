package LeetCode;
import java.util.Arrays;


public class MergeSortedArray {
	public static void main (String[] args) {
		int[] A = new int[9];
		int[] B = {1};
		A[0] = 2;
		A[1] = 4;
		new MergeSortedArray().merge(A, 1, B, B.length);
		System.out.println(Arrays.toString(A));
	}
	
	public void merge(int A[], int m, int B[], int n) {
	    int num = m + n;
	    int k = m + n - 1;
	    
	    while (k >= 0) {
	    	if (n - 1 < 0 || (m - 1 >= 0 && A[m - 1] >= B[n - 1])) {
	    		A[k] = A[m - 1];
	    		m--;
	    	} else if (m - 1 <= 0 || (n - 1 >= 0 && A[m - 1] < B[n - 1])){
	    		A[k] = B[n - 1];
	    		n--;
	    	}
	    	k--;
	    }
	 }
}
