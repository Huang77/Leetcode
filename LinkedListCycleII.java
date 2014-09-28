package LeetCode;



public class LinkedListCycleII {
	
	public static void main (String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = c;
		
		ListNode result = detectCycle(a);
		System.out.println(result.val);
	}
	
    public static ListNode detectCycle(ListNode head) {
    	if (head == null || head.next == null) {
    		return null;
    	}
    	ListNode slow = head, fast = head;
    	boolean hasCycle = false;
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if (slow == fast) {
    			hasCycle = true;
    			break;
    		}
    	}
    	if (!hasCycle) {
    		return null;
    	}
    	slow = head;
    	while (slow != fast) {
    		slow = slow.next;
    		fast = fast.next;
    	}
    	return slow;
    }
}
