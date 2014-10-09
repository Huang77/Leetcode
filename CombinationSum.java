package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static void main (String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> list = combinationSum(candidates, target);
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
        	return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        combinationSum_Helper(resultList, candidates, target, 0, curList, 0);
        return resultList;
    }
	public static void combinationSum_Helper (List<List<Integer>> resultList, int[] candidates, int target, int curSum, List<Integer> curList, int level) {
		if (curSum == target) {
			ArrayList<Integer> temp = new ArrayList<Integer>(curList);
			resultList.add(temp);
		} else if (curSum < target) {
			for (int i = level; i < candidates.length; i++) {
				curSum += candidates[i];
				curList.add(candidates[i]);
				combinationSum_Helper (resultList, candidates, target, curSum, curList, i);
				curSum -= candidates[i];
				curList.remove(curList.size() - 1);
			}
		}
	}
}
