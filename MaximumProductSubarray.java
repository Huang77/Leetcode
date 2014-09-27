package LeetCode;

public class MaximumProductSubarray {
	public static void main (String[] args) {
		int[] A = {0,2, -1, -3};
		System.out.println(maxProduct(A));
	}
	public static int maxProduct(int[] A) {
        if (A == null) {
        	return 0;
        } 
        if (A.length == 1) {
        	return A[0];
        }

        int curMax = A[0];
        int curMin = A[0];
        int max = A[0];
        int temp;
        for (int i = 1; i < A.length; i++) {
        	curMax *= A[i];
        	curMin *= A[i];
        	if (curMax < curMin) {
        		temp = curMin;
        		curMin = curMax;
        		curMax = temp;
        	}
        	curMin = curMin < A[i] ? curMin : A[i];
        	curMax = curMax > A[i] ? curMax : A[i];
        	
        	if (max < curMax) {
        		max = curMax;
        	}
        }
        return max;
    }
}
