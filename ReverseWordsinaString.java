package LeetCode;

public class ReverseWordsinaString {
	public static void main (String[] args) {
		String s ="the sky is    blue    ";
		s = reverseWords(s);
		System.out.println(s);
	}
	public static String reverseWords(String s) {
        if (s == null) {
        	return null;
        }
        s = cleanSpace(s);
        if (s.length() <= 1) {
        	return s;
        }
        s = reverseHelper(s, 0, s.length() - 1);
        int start = 0; 
        for (int i = 1; i < s.length(); i++) {
        	if (s.charAt(i) == ' ') {
        		s = reverseHelper(s, start, i - 1);
        		start = i + 1;
        	} else if (i == s.length() - 1) {
        		s = reverseHelper(s, start, i);
        	}
        }
        return s;   
    }
	public static String cleanSpace (String s) {
		s = s.trim();
		StringBuilder newString = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i == 0) {
				if (chars[i] != ' ') {
					newString.append(chars[i]);
				}
			} else {
				if (chars[i - 1] == ' ' && chars[i] == ' ') {
					continue;
				} else {
					newString.append(chars[i]);
				}
			}
		}
		return newString.toString();
	}
	public static String reverseHelper (String s, int start, int end) {
		if (start == end) {
			return s;
		}
		
		int mid = ((end - start) >> 1) + start;
		char[] array = s.toCharArray();
		char temp;
		for (int i = 0; i <= mid - start; i++) {
			temp = array[i + start];
			array[i + start] = array[end - i];
			array[end - i] = temp;
		}
		return new String(array);
	}
}
