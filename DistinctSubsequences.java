package LeetCode;

public class DistinctSubsequences {
	public static void main (String[] args) {
		String S = "";
		String T = "rabbit";
		System.out.println(numDistinct(S, T));
	}
	
	public static int numDistinct(String S, String T) {
        if (S == null || T == null) {
        	return 0;
        }
        if (S.length() == 0 || T.length() == 0) {
        	return 0;
        }
        int sizeS = S.length();
        int sizeT = T.length();
        int[][] table = new int[sizeT][sizeS];
        
        if (T.charAt(0) == S.charAt(0)) {
        	table[0][0] = 1;
        } else {
        	table[0][0] = 0;
        }
        
        for (int i = 1; i < sizeS; i++) {
        	if (T.charAt(0) == S.charAt(i)) {
        		table[0][i] = table[0][i - 1] + 1;
        	} else {
        		table[0][i] = table[0][i - 1];
        	}
        }
        for (int i = 1; i < sizeT; i++) {
        	table[i][0] = 0;
        }
        
        for (int i = 1; i < sizeT; i++) {
        	for (int j = 1; j < sizeS; j++) {
        		if (i > j) {
        			table[i][j] = 0;
        		}
        		if (T.charAt(i) == S.charAt(j)) {
        			table[i][j] = table[i][j - 1] + table[i - 1][j - 1];
        		} else {
        			table[i][j] = table[i][j - 1];
        		}
        	}
        }
        return table[sizeT - 1][sizeS - 1];
    }
}
