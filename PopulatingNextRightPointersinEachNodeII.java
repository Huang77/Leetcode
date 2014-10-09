package LeetCode;

import java.util.LinkedList;

public class PopulatingNextRightPointersinEachNodeII {

	 
	 public static void main (String[] args) {
		 TreeLinkNode root = new TreeLinkNode(1);
		 root.left = new TreeLinkNode(2);
		 root.right = new TreeLinkNode(3);
		 connect(root);
	 }
	 
	 public static void connect(TreeLinkNode root) {
		 if (root == null) {
			 return;
		 }
		 LinkedList<TreeLinkNode> lastQueue = new LinkedList<TreeLinkNode>();
		 LinkedList<TreeLinkNode> newQueue = new LinkedList<TreeLinkNode>();
		 lastQueue.addLast(root);
		 connect_helper(lastQueue, newQueue);
	 }
	 
	 public static void connect_helper (LinkedList<TreeLinkNode> lastQueue, LinkedList<TreeLinkNode> newQueue) {
		 if (lastQueue.isEmpty()) {
			 return;
		 }
		 TreeLinkNode temp = null;
		 while (!lastQueue.isEmpty()) {
			 temp = lastQueue.poll();
			 if (lastQueue.peek() != null) {
				 temp.next = lastQueue.peek();
			 }
			 if (temp.left != null) {
				 newQueue.addLast(temp.left);
			 }
			 if (temp.right != null) {
				 newQueue.addLast(temp.right);
			 }
		 }
		 if (temp != null) {
			 temp.next = null;
		 }
		 lastQueue.clear();
		 connect_helper(newQueue, lastQueue);
	 }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
