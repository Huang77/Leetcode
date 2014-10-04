package LeetCode;

public class ConvertSortedListtoBinarySearchTree {
	public static void main (String[] args) {
		ListNode head = new ListNode("1->2->3");
		TreeNode root = sortedListToBST(head);
		System.out.println("end");
	}
	
	
    public static TreeNode sortedListToBST(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	if (head.next == null) {
    		return new TreeNode(head.val);
    	}
    	ListNode slow = head, fast = head;
    	ListNode pre = head;
    	while (fast.next != null && fast.next.next != null) {
    		pre = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	ListNode newHead = slow;
    	ListNode left, right;
    	if (newHead == head) {
    		left = null;
    	} else {
    		pre.next = null;
    		left = head;
    	}
    	right = newHead.next;
    	
    	TreeNode root = new TreeNode(newHead.val);
    	root.left = sortedListToBST(left);
    	root.right = sortedListToBST(right);
    	return root;
    }
}
