package LeetCode;

import java.util.HashMap;



 /**
  * Problem: A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
  * Return a deep copy of the list.
  * 
  * The most appearent solution may be that first copy the listnode one by one, and than find the random node of each node, this is an O(n*n) algorithm;
  * And then, my solution is to use hashmap<origin node, copy node>, then we can find the random node in O(1), and the total time complexity is O(n);
  * However, there is an elegant algorithm with O(1) space and O(n), beautiful.
  * 
  * @author HXX
  *
  */
 

//Definition for singly-linked list with a random pointer.
class RandomListNode {
  int label;
  RandomListNode next, random;
  RandomListNode(int x) { this.label = x; }
};

public class CopyListwithRandomPointer {
	public static void main (String[] args) {
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.next.random = head;
		RandomListNode newHead = copyRandomList(head);
	}
	public static RandomListNode copyRandomListWithHashMap(RandomListNode head) {
		if (head == null) {
			return null;
		}
        RandomListNode newHead = new RandomListNode(head.label);
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(head, newHead);
        RandomListNode tempNode = newHead;
        RandomListNode originNode = head;
        while (originNode.next != null) {
        	tempNode.next = new RandomListNode(originNode.next.label);
        	map.put(originNode.next, tempNode.next);
        	tempNode = tempNode.next;
        	originNode = originNode.next;
        }
        originNode = head;
        tempNode = newHead;
        while (originNode != null) {
        	tempNode.random = map.get(originNode.random);
        	tempNode = tempNode.next;
        	originNode = originNode.next;
        }
        return newHead;
    }
	
	// elegant algorithm with O(1) space and O(n) time
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		// insert new node to the origin list
		RandomListNode cursor = head;
		while (cursor != null) {
			RandomListNode newNode = new RandomListNode(cursor.label);
			newNode.next = cursor.next;
			cursor.next = newNode;
			cursor = cursor.next.next;
		}
		cursor = head;
		// set the random node 
		while (cursor != null) {
			if (cursor.random != null) {
				cursor.next.random = cursor.random .next;
			}
			cursor = cursor.next.next;
		}
		cursor = head;
		// split the two list
		RandomListNode newHead = cursor.next;
		RandomListNode tempNode = newHead;
		while(cursor != null) {
			cursor.next = tempNode.next;
			if (cursor.next != null) {
				tempNode.next = cursor.next.next;
			}
			cursor = cursor.next;
			tempNode = tempNode.next;
		}
		return newHead;
	}
}
