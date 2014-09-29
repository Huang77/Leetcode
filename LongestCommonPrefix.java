package LeetCode;

public class LongestCommonPrefix {
	public static void main (String[] args) {
		String[] strs = {"c","c","cbcccc"};
		System.out.println(longestCommonPrefix(strs));
	}
	
    public static String longestCommonPrefix(String[] strs) {  
    	if (strs == null || strs.length == 0) {
        	return "";
        } 
    	for (int i = 0; i < strs.length; i++) {
    		if (strs[i] == null || strs[i].length() == 0) {
    			return "";
    		}
    	}
    	StringBuilder prefix = new StringBuilder();
    	int index = -1;
    	char curChar;
    	while (true) {
    		index++;
    		if (index < strs[0].length()) {
    			curChar = strs[0].charAt(index);
    		} else {
    			return prefix.toString();
    		}
    		for (int i = 1; i < strs.length; i++) {
    			if (index >= strs[i].length() || strs[i].charAt(index) != curChar) {
    				return prefix.toString();
    			}
    		}
    		prefix.append(curChar);
    	}
    }
}
