package LeetCode;

public class ReorderList {
	public static void main (String[] args) {
		ListNode list = new ListNode("1->2->3->4");
		reorderList(list);
		list.print();
	}
	
	public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
        	return ;
        }
        // get the middle node 
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        
        // reverse the right list
        ListNode pre = null, cur = rightHead, next;
        while (cur != null) {
        	next = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = next;
        }
        rightHead = pre;
        
        slow = head.next;
        fast = rightHead;
        next = head;
        while (slow != null && fast != null) {
        	next.next = fast;
        	fast = fast.next;
        	next.next.next = slow;
        	slow = slow.next;
        	next = next.next.next;
        }
        if (slow != null) {
        	next.next = slow;
        	next.next.next = null;
        }
        if (fast != null) {
        	next.next = fast;
        	next.next.next = null;
        }
    }
}
