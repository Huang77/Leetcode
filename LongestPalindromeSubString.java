package LeetCode;

public class LongestPalindromeSubString {
	public static void main (String[] args) {
		LongestPalindromeSubString test = new LongestPalindromeSubString();
		String str = "abccccc";
		System.out.println(test.solution1(str));
		System.out.println(test.solution2(str));
		System.out.println(test.solution3(str));
	}
	// Approach 1 : Native Approach, O(n^3)
	public String solution1 (String s) {
		String result = "";
		String subString;
		int maxLength = 1;
		int num = s.length();
		for (int i = 0; i < num; i++) {
			for (int j = i + 1; j < num + 1; j++) {
				subString = s.substring(i, j);
				if (isPalindrome(subString)) {
					if (subString.length() >= maxLength) {
						maxLength = subString.length();
						result = subString;
					}
				}
			}
		}
		return result;
	}
	// judge a string whether is palindrome
	private boolean isPalindrome (String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 -i)) {
				return false;
			}
		}
		return true;
	}
	// End Approach 1
	
	// Approach 2: Dynamic Programing, Time O(n^2), Space O(n^2)
	public String solution2 (String s) {
		if (s == null) {
			return null;
		}
		
		int num = s.length();
		
		if (num <= 1) {
			return s;
		}
		
		String result = s.substring(num - 1);
		boolean[][] table = new boolean[num][num];
		int maxLength = 0;
		
		
		table[num - 1][num - 1] = true;
		for (int i = 0; i < num - 1; i++) {
			table[i][i] = true;
			table[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
			if (table[i][i + 1]) {
				result = s.substring(i, i + 2);
			}
		}
		
		for (int l = 3; l <= num; l++) {
			for (int i = 0; i < num - l + 1; i++) {
				table[i][i + l - 1] = (table[i + 1][i + l - 2] && (s.charAt(i) == s.charAt(i + l - 1)));
				if (table[i][i + l - 1] && l > maxLength) {
					result = s.substring(i, i + l);
					maxLength = result.length();
				}
			}
		}
		
		return result;
	}
	// End Approach 2
	
	// Approach 3: Simple Approach, Time O(n^2), Space O(1)
	public String solution3 (String s) {
		String result = null;
		int num = s.length();
		int maxLength = 0;
		String temp;
		for (int i = 0; i < num; i++) {
			temp = isPalindromeFromPivot(s, i, i);
			if (temp.length() >= maxLength) {
				maxLength = temp.length();
				result = temp;
			}
			temp = isPalindromeFromPivot(s, i, i + 1);
			if (temp.length() >= maxLength) {
				maxLength = temp.length();
				result = temp;
			}
		}
		return result;
	}
	private String isPalindromeFromPivot (String s, int begin, int end) {
		int num = s.length();
		while (begin >= 0 && end < num && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		//begin需要加1的原因在于begin在最后一次循环中减一，而end在最后一次循环加一，正好符合substirng()的参数要求
		return s.substring(begin + 1, end);
	}
	
}
