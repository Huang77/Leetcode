package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;


public class LinkedListCycle {
	
	public static void main (String[] args) {
		LinkedListCycle test = new LinkedListCycle();
		ListNode a = test.new ListNode(1);
		ListNode b = test.new ListNode(2);
		ListNode c = test.new ListNode(3);
		ListNode d = test.new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = b;
		
		System.out.println(test.hasCycle1(a));
	}
	
	  //Definition for singly-linked list.
	  class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	   // My Solution, use extra space O(n)
	    public boolean hasCycle(ListNode head) {
	        HashSet<ListNode> visitedNodes = new HashSet<ListNode>();
	        ListNode curNode = head;
	        
	        while (curNode != null) {
	        	if (visitedNodes.contains(curNode)) {
	        		return true;
	        	} else {
	        		visitedNodes.add(curNode);
	        	}
	        	curNode = curNode.next;
	        }
	        return false;
	    }
	    
	    // Fast/Slow Runner Solution
	    public boolean hasCycle1(ListNode head) {
	    	ListNode fast = head, slow = head;
	    	while (fast != null && fast.next != null) {
	    		fast =  fast.next.next;
	    		slow = slow.next;
	    		if (fast == slow) return true;
	    	}
	    	return false;
	    	
	    }
	    
	    // Another solutions: modify the val or next pointer of the visitedNodes, and use it to check whether the node is visited
	    public boolean hasCycle2(ListNode head) {
	    	ListNode temp;
	    	while (head != null) {
	    		if (head.next == head) return true;
	    		temp = head.next;
	    		head.next = head;
	    		head = temp;
	    	}
	    	return false;
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
