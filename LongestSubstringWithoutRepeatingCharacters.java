package LeetCode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main (String[] args) {
		String s = "";
		System.out.println(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
        	return 0;
        }
        if (s.length() <= 1) {
        	return s.length();
        }
        HashMap<Character, Integer> lastIndex = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        int max = 0;
        int[] count = new int[s.length()];
        count[0] = 1;
        lastIndex.put(chars[0], 0);
        for (int i = 1; i < chars.length; i++) {
        	if (lastIndex.containsKey(chars[i]) && (i - lastIndex.get(chars[i]) <= count[i - 1])) {
        		count[i] = i - lastIndex.get(chars[i]);
        	} else {
        		count[i] = count[i - 1] + 1;
        	}
        	if (max < count[i]) {
        		max = count[i];
        	}
        	lastIndex.put(chars[i], i);
        }
        return max;
    }
}
