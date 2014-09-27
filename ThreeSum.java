package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main (String[] args) {
		int[] num = {-1, -1, -1, 1};
		List<List<Integer>> list = threeSum(num);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i).toArray()));
		}
		
	}
	public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (num == null || num.length <= 2) {
        	return list;
        }
        Arrays.sort(num);
        int min, max;
        int sum;
        for (int i = num.length - 1; i >= 0; i--) {
        	if (i + 1 < num.length && num[i] == num[i + 1]) {
        		continue;
        	}
        	sum = -num[i];
        	min = 0;
        	max = i - 1;
        	while (min < max) {
        		if (min >= 1 && num[min] == num[min - 1]) {
        			min++;
        			continue;
        		}
        		if (max + 1 < i && num[max] == num[max + 1]) {
        			max--;
        			continue;
        		}
        		if (num[min] + num[max] < sum) {
        			min++;
        		} else if (num[min] + num[max] > sum) {
        			max--;
        		} else {
        			ArrayList<Integer> temp = new ArrayList<Integer>();
        			temp.add(num[min]);
        			temp.add(num[max]);
        			temp.add(num[i]);
        			list.add(temp);
        			min++;
        			max--;
        		}
        	}
        }
        return list;
    }
}
