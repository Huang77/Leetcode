package LeetCode;

import java.util.Arrays;

public class NextPermutation {
	public static void main (String[] args) {
		int[] num = {2, 6, 3, 1, 4, 1};
		nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
	
	public static void nextPermutation(int[] num) {
		 int p = -1, next = -1;
		 for (int i = num.length - 1; i >= 1; i--) {
			 if (num[i] > num[i - 1]) {
				 p = i - 1;
				 break;
			 }
		 }
		 if (p == -1) {
			 Arrays.sort(num);
			 return;
		 }
		 for (int i = p + 1; i <= num.length - 2; i++) {
			 if (num[i] > num[p] && num[i + 1] <= num[p]) {
				 next = i;
				 break;
			 }
		 }
		 if (next == -1) {
			 next = num.length - 1;
		 }
		 int temp = num[p];
		 num[p] = num[next];
		 num[next] = temp;
		 Arrays.sort(num, p + 1, num.length);
	 }
}
