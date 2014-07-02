import java.util.Set;
import java.util.TreeSet;

public class WordBreak {
	public static void main (String[] args) {
		WordBreak test = new WordBreak();
		String str = "LeetCode";
		Set<String> dict = new TreeSet<String>();
		dict.add("Leet");
		dict.add("Co");
		dict.add("de");
		System.out.println(test.wordBreak2(str, dict));
	}
	// Approach 1: Time O(2^n), recursive
	public boolean wordBreak (String s, Set<String> dict) {
		return findWord(s, dict, 0);
	}
	private boolean findWord (String s, Set<String> dict, int cur) {
		if (cur == s.length()) {
			return true;
		}
		
		int strLen;
		for (String str: dict) {
			strLen = str.length();
			if (cur + strLen > s.length()) {
				continue;
			}
			if (s.substring(cur, cur + strLen).equals(str)) {
				if (findWord(s, dict, cur + strLen)) {
					return true;
				}
			}
		}
		return false;
	}
	// Approach 2: Time O(str.length() * dict.size())
	public boolean wordBreak2 (String s, Set<String> dict) {
		boolean[] table = new boolean[s.length() + 1]; //要加一
		table[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (!table[i]) {
				continue;
			}
			for (String str: dict) {
				if (i + str.length() > s.length()) {
					continue;
				}
				if (table[i + str.length()]) {
					continue;
				}
				if (s.substring(i, i + str.length()).equals(str)) {
					table[i + str.length()] = true;
				}
			}
		}
		return table[table.length - 1];
	}
}
