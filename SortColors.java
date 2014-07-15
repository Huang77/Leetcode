package LeetCode;

import java.util.Arrays;

public class SortColors {
	public static void main (String[] args) {
		SortColors test = new SortColors();
		int[] A = {0,0,1,2,2,1,1,0,0,0,0,0,0,1,2,2,1,2,1,2};
		test.sortColors(A);
		System.out.println(Arrays.toString(A));
	}
	
	public void sortColors(int[] A) {
	        int pos0 = 0, pos2 = A.length - 1;
	        int temp;
	        for (int i = 0; i < A.length; i++) {
	        	if (A[i] == 0) {
	        		temp = A[pos0];
	        		A[pos0] = A[i];
	        		A[i] = temp;
	        		pos0++;
	        		
	        	} else if (A[i] == 2) {
	        		temp = A[pos2];
	        		A[pos2] = A[i];
	        		A[i] = temp;
	        		pos2--;
	        		i--;
	        	}
	        	if (i >= pos2) break;
	        }
	 }
	// nice solution!
	 public void sortColors1(int[] A) {


		    int i=-1, j=-1, k=-1;

		    for(int p = 0; p < A.length; p++)
		    {
		        if(A[p] == 0)
		        {
		            A[++k]=2;
		            A[++j]=1;
		            A[++i]=0;
		        }
		        else if (A[p] == 1)
		        {
		            A[++k]=2;
		            A[++j]=1;

		        }
		        else if (A[p] == 2)
		        {
		            A[++k]=2;
		        }
		    }
	 }
}
