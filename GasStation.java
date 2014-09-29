package LeetCode;


// reference: http://blog.csdn.net/sbitswc/article/details/34670367

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int size = gas.length;
    	int[] left = new int[size];
    	
    	int totalLeft = 0;
    	int subArraySum = 0;
    	int start = 0;
    	for (int i = 0; i < size; i++) {
    		left[i] = gas[i] - cost[i];
    		totalLeft += left[i];
    		subArraySum += left[i];
    		if (subArraySum < 0) {
    			subArraySum = 0;
    			start = i + 1;
    		}
    	}
    	if (totalLeft < 0) {
    		return -1;
    	} else {
    		return start;
    	}
    }
}
