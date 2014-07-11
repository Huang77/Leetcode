package LeetCode;

public class MaximumSubArray {
	public static void main (String[] args) {
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubArray test = new MaximumSubArray();
		System.out.println(test.maxSubArray(A));
	}
	public int maxSubArray(int[] A) {
        int[] sum = new int[A.length];
        int[] start = new int[A.length];
        int e;
        int s;
        
        sum[0] = A[0];
        int max = A[0];
        s = e = 0;
        
        for (int i = 1; i < A.length; i++) {
        	//sum[i] = (sum[i - 1] + A[i]) >= A[i] ? sum[i - 1] + A[i] : A[i];
        	if (sum[i - 1] + A[i] < A[i]) {
        		sum[i] = A[i];
        		start[i] = i;
        	} else {
        		sum[i] = sum[i - 1] + A[i];
        		start[i] = start[i - 1];
        	}
        	if (max < sum[i]) {
        		max = sum[i];
        		s = start[i];
        		e = i;
        	}
        }
        System.out.println(s + ":" + e);
        return max;
    }
}
