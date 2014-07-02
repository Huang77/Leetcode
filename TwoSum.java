import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {
	public static void main (String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 18;
		System.out.println(Arrays.toString(new TwoSum().twoSum(numbers, target)));
	}
	
	public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
        	if (map.containsKey(numbers[i])) {
        		result[0] = map.get(numbers[i]) + 1;
        		result[1] = i + 1;
        		break;
        	} else {
        		map.put(target - numbers[i], i);
        	}
        }
        return result;
    }
}
