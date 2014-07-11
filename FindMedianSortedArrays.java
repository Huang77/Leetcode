package LeetCode;

public class FindMedianSortedArrays {
	public static void main (String[] args) {
		FindMedianSortedArrays test = new FindMedianSortedArrays();
		int[] A = {1};
		int[] B = {1};
		System.out.println(test.findMedianSortedArrays(A, B));
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int num = A.length + B.length;
        int i = 0, j = 0, k = 0;
        int[] C = new int[num];
        
        if (A.length == 0) {
        	C = B;
        } else if (B.length == 0) {
        	C = A;
        } else {
        	 while (i < A.length || j < B.length) {	
             	if (j == B.length || (i < A.length && A[i] <= B[j])) {
             		C[k] = A[i];
             		i++;
             	} else if (i == A.length || (j < B.length && A[i] > B[j])){
             		C[k] = B[j];
             		j++;
             	}
             	k++;
             }
        }
        
        
       
        if (num % 2 == 1) {
        	return 1.0 * C[num / 2];
        } else {
        	return (C[num / 2 - 1] + C[num / 2]) / 2.0;
        }
    }
}
