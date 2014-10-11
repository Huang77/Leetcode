package LeetCode;

public class DecodeWays {
	public static void main (String[] args) {
		String s = "100";
		System.out.println(numDecodings(s));
	}
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        if (s.length() == 1 && s.charAt(0) != '0') {
        	return 1;
        }
        if (s.charAt(0) == '0') {
        	return 0;
        }
        
        int[] table = new int[s.length()];
        table[0] = 1;
        
        if (s.charAt(1) == '0') {
        	if (s.charAt(0) <= '2') {
        		table[1] = 1;
        	} else {
        		return 0;
        	}
        } else {
    		if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6')) {
    			table[1] = 2;
    		} else {
    			table[1] = 1;
    		}
        }
        
        
        for (int i = 2; i < s.length(); i++) {
        	if (s.charAt(i) == '0') {
            	if (s.charAt(i - 1) == '2' || s.charAt(i - 1) == '1') {
            		table[i] = table[i - 2];
            	} else {
            		return 0;
            	}
        	} else if (s.charAt(i - 1) > '2') {
        		table[i] = table[i - 1];
        	} else {
        		if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
        			table[i] = table[i - 2] + table[i - 1];
        		} else {
        			table[i] = table[i - 1];
        		}
        	}
        }
        return table[s.length() - 1];
    }
}
