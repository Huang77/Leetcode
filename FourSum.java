package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FourSum {
	public static void main (String[] args) {
		int[] num = {-1,2,2,-5,0,-1,4};
		int target = 3;
		List<List<Integer>> list = fourSum(num, target);
		System.out.print(Arrays.toString(list.toArray()));
	}
    public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4) {
        	return list;
        }
        Arrays.sort(num);
        
        int start, end;
        int sum;
        for (int i = 0; i < num.length - 3; i++) {
        	for (int j = i + 1; j < num.length - 2; j++) {
        		start = j + 1;
        		end = num.length - 1;
        		while (start < end) {
        			sum = num[i] + num[j] + num[start] + num[end];
        			if (sum == target) {
        				List<Integer> newList = new ArrayList<Integer>();
        				newList.add(num[i]);
        				newList.add(num[j]);
        				newList.add(num[start]);
        				newList.add(num[end]);
        				list.add(newList);
        				while (start + 1 < num.length && num[start + 1] == num[start]) start++;
        				start++;
        				while (end - 1 >= 0 && num[end - 1] == num[end]) end--;
        				end--;
        			} else if (sum < target) {
        				while (start + 1 < num.length && num[start + 1] == num[start]) start++;
        				start++;
        			} else {
        				while (end - 1 >= 0 && num[end - 1] == num[end]) end--;
        				end--;
        			}
        			
        			
        		}
        		while (j < num.length - 3 && num[j + 1] == num[j]) j++;
        	}
        	while (i < num.length - 4 && num[i + 1] == num[i]) i++;
        }
        return list;
    }
}
