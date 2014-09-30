package LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main (String[] args) {
		int[] num = {-1,1,1,0,11,1,1,1};
		int target = 1;
		System.out.println(threeSumClosest(num, target));
	}
	public static int threeSumClosest(int[] num, int target) {
		int minDiff = Integer.MAX_VALUE;
		int sum = 0;
		int start, end;
		int result = 0;
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 2; i++) {
			start = i + 1;
			end  = num.length - 1;
			while (start < end) {
				sum = num[i] + num[start] + num[end];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					if (minDiff > target - sum) {
						minDiff = target - sum;
						result = sum;
					}
					start++;
				} else if (sum > target) {
					if (minDiff > sum - target) {
						minDiff = sum - target;
						result =sum;
					}
					end--;
				}
			}
			while(num[i + 1] == num[i]) i++;
		}
		return result;
    }
}
