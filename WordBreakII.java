package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static void main (String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("dog");
		dict.add("and");
		dict.add("sand");
		dict.add("cat");
		dict.add("cats");
		List<String> list = wordBreak(s, dict);
		System.out.println(Arrays.toString(list.toArray()));
	}
	public static List<String> wordBreak(String s, Set<String> dict) {
		List<String> list = new ArrayList<String>();
        if (s == null || s.length() <= 0|| dict == null) {
        	return list;
        }
        if (canBreak(s, dict) == false) {
        	return list;
        }
        helper(s, dict, 0, "", list);
        return list;
    }
	public static void helper (String s, Set<String> dict, int start, String lastStr, List<String> list) {
		if (start >= s.length()) {
			list.add(lastStr.trim());
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (dict.contains(s.substring(start, i + 1))) {
				helper(s, dict, i + 1, lastStr + " " + s.substring(start, i + 1), list);
			}
		}
	}
	public static boolean canBreak (String s, Set<String> dict) {
		boolean[] possible = new boolean[s.length() + 1];
		possible[0] = true;
		for (int i = 1; i < possible.length; i++) {
			if (possible[i - 1] == false) {
				continue;
			} 
			for (String str : dict) {
				int len = str.length();
				if (i + len - 1 > s.length()) {
					continue;
				}
				if (possible[i + len - 1] == true) {
					continue;
				}
				if (s.substring(i - 1, i + len - 1).equals(str)) {
					possible[i + len - 1] = true;
				}
			}
		}
		return possible[s.length()];
	}
}
