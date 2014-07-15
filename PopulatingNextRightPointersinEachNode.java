package LeetCode;

public class PopulatingNextRightPointersinEachNode {
	
	 // Definition for binary tree with next pointer.
	  public class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }
	 
	public void connect(TreeLinkNode root) {
		TreeLinkNode levelStart = root;
		TreeLinkNode curNode = root;
        while (curNode != null && curNode.left != null) {
        	curNode.left.next = curNode.right;
        	if (curNode.next != null) {
        		curNode.right.next = curNode.next.left;
        		curNode = curNode.next;
        	} else {
        		curNode.right.next = null;
        		levelStart = levelStart.left;
        		curNode = levelStart;
        	}
        }
    }
}
