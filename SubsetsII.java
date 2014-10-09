package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	static public void main (String[] args) {
		int[] S = {1,2,2};
		System.out.println(Arrays.toString(subsetsWithDup(S).toArray()));
		
	}
    public static List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        if (num != null) {
        	Arrays.sort(num);
        	subsetWithDup_helper(num, resultList, curList, 0);
        }
        return resultList;
    }
    
    public static void subsetWithDup_helper (int[] num, List<List<Integer>> resultList, List<Integer> curList, int level) {
    	if (level <= num.length) {
    		resultList.add(new ArrayList<Integer>(curList));
    	}
    	for (int i = level; i < num.length; i++) {
    		curList.add(num[i]);
    		subsetWithDup_helper(num, resultList, curList, i + 1);
    		curList.remove(curList.size() - 1);
    		while(i < num.length - 1 && num[i] == num[i + 1]) i++;
    	}
    }
    
}
