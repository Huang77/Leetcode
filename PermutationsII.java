package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
	public static void main (String[] args) {
		int[] num = {2,2,1,1};
		List<List<Integer>> list = permuteUnique(num);
		
	}
	public static List<List<Integer>> permuteUnique(int[] num) {
        if (num == null) {
        	return null;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        permuteUnique_helper(num, 0, num.length - 1, list);
        return list;
    }
	public static void permuteUnique_helper (int[] num, int start, int end, List<List<Integer>> list) {
		if (start > end) {
			List<Integer> newList = new ArrayList<Integer>();
			for (int i = 0; i <= end; i++) {
				newList.add(num[i]);
			}
			list.add(newList);
		} else {
			HashSet<Integer> used = new HashSet<Integer>();
			for (int i = start; i <= end; i++) {
				if (!used.contains(num[i])) {
					used.add(num[i]);
					swap(num, start, i);
					permuteUnique_helper(num, start + 1, end, list);
					swap(num, start, i);
				}
			}
		}
	}
	public static void swap (int[] num, int index1, int index2) {
		int temp = num[index1];
		num[index1] = num[index2];
		num[index2] = temp;
	}
}
