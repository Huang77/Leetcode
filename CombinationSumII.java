package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static void main (String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> list = combinationSum2(candidates, target);
	}
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
    	if (num == null) {
    		return null;
    	}
    	Arrays.sort(num);
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	List<Integer> curList = new ArrayList<Integer>();
    	combinationSum2_helper(num, target, resultList, curList, 0, 0);
    	return resultList;
    }
    
    public static void combinationSum2_helper(int[] num, int target, List<List<Integer>> resultList, List<Integer> curList, int curSum, int level) {
    	if (curSum == target) {
    		resultList.add(new ArrayList<Integer>(curList));
    	} else if (curSum < target) {
    		for (int i = level; i < num.length; i++) {
    			curSum += num[i];
    			curList.add(num[i]);
    			combinationSum2_helper(num, target, resultList, curList, curSum, i + 1);
    			curSum -= num[i];
    			curList.remove(curList.size() - 1);
    			while (i + 1 < num.length && num[i] == num[i + 1]) {
    				i++;
    			}
    		}
    	}
    }
}
