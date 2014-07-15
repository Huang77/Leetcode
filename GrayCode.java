package LeetCode;

import java.awt.List;
import java.util.ArrayList;

public class GrayCode {
	public static void main (String[] args) {
		
	}
	
	// not the same order with leetcode's instance
	public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> curList = new ArrayList<Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        curList.add(0);
        if (n == 0) return curList;
        curList.add(1);
        if (n == 1) return curList;
        int temp;
        for (int i = 2; i <= n; i++) {
        	newList.clear();
        	for (int j = 0; j < curList.size(); j++) {
        		temp = curList.get(j);
        		newList.add(temp * 2);
        	}
        	for (int j = curList.size() - 1; j >= 0; j--) {
        		temp = curList.get(j);
        		newList.add(temp * 2 + 1);
        	}
        	curList = (ArrayList<Integer>) newList.clone();
        }
        return curList;
    }
	
	public ArrayList<Integer> grayCode1(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        if (n <= 1) return list;
        int trans;
        for (int i = 0; i < n; i++) {
        	trans = 1 << i;
        	for (int j = list.size() - 1; j >= 0; j++) {
        		list.add((list.get(j) + trans));
        	}
        }
        return list;
    }
}
