package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	public static void main (String[] args) {
		String digits = "11";
		List<String> result = letterCombinations(digits);
		System.out.println(Arrays.toString(result.toArray()));
	}
	public static List<String> letterCombinations(String digits) {
        if (digits == null) {
        	return null;
        }
        String[] chars = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz",};
        LinkedList<String> list = new LinkedList<String>();
        int index;
        int lastNum = 0;
        String temp;
        for (int i = 0; i < digits.length(); i++) {
        	index = digits.charAt(i) - '0';
        	if (index < 2) {
        		continue;
        	}
        	if (lastNum == 0) {
        		lastNum = chars[index].length();
        		for (int j = 0; j < chars[index].length(); j++) {
        			list.addLast(chars[index].charAt(j) + "");
        		}
        	} else {
        		for (int j = 0; j < lastNum; j++) {
        			temp = list.removeFirst();
        			for (int k = 0; k < chars[index].length(); k++) {
        				list.add(temp + chars[index].charAt(k));
        			}
        		}
        		lastNum *= chars[index].length();
        	}	
        }
        if (list.isEmpty()) {
        	list.add("");
        }
        return list;
    }
}
