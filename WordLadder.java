package LeetCode;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;


public class WordLadder {
	public static void main (String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new TreeSet<String>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		dict.add("lot");
		dict.add("log");
		WordLadder test = new WordLadder();
		System.out.println(test.ladderLength(start, end, dict));
	}
	public int ladderLength(String start, String end, Set<String> dict) {
		
		if (dict.size() == 0) {
			return 0;
		}
		
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        
        wordQueue.add(start);
        distanceQueue.add(1);
        
        String curWord;
        int curLen;
        while(!wordQueue.isEmpty()) {
        	curWord = wordQueue.pop();
        	curLen = distanceQueue.pop();
        	
        	if (curWord.equals(end)) {
        		return curLen;
        	}
        	
        	
        	for (int i = 0; i < curWord.length(); i++) {
        		char[] curCharArray = curWord.toCharArray();
        		for (char c = 'a'; c <= 'z'; c++) {
        			if (curCharArray[i] == c) {
        				continue;
        			}
        			curCharArray[i] = c;
        			String newStr = new String(curCharArray);
        			if (newStr.equals(end)) {
        				return curLen + 1;
        			}
        			if (dict.contains(newStr)) {
        				wordQueue.add(newStr);
        				distanceQueue.add(curLen + 1);
        				dict.remove(newStr);
        			}
        		} 
        	}
        }	
        return 0;
        
    }
	
}
