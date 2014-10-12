package LeetCode;

import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) {
        	return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>();
        char temp;
        char top;
        for (int i = 0; i < s.length(); i++) {
        	temp = s.charAt(i);
        	if (temp == '(' || temp == '{' || temp == '[') {
        		stack.push(temp);
        	} else {
        		if (stack.isEmpty()) {
        			return false;
        		}
        		top = stack.pop();
        		if ((temp == ')' && top != '(') || (temp == '}' && top != '{') || (temp == ']' && top != '[')) {
        			return false;
        		}
        	}
        }
        if (!stack.isEmpty()) {
        	return false;
        }
        return true;
    }
}
