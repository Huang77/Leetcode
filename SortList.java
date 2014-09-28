package LeetCode;


public class SortList {
	public static void main (String[] args) {
		ListNode head = new ListNode("5->3->1->2");
		head = sortList(head);
		head.print();
	}
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode middle = getMiddleNode(head);
        ListNode rightList = middle.next;
        middle.next = null;
        return mergeTwoSortedList(sortList(head), sortList(rightList));
    }
    public static ListNode mergeTwoSortedList (ListNode list1, ListNode list2) {
    	ListNode preHead = new ListNode(0);
    	ListNode cur = preHead;
    	while (list1 != null && list2 != null) {
    		if (list1.val >= list2.val) {
    			cur.next = list2;
    			list2 = list2.next;
    		} else {
    			cur.next = list1;
    			list1 = list1.next;
    		}
    		cur = cur.next;
    	}
    	if (list1 != null) {
    		cur.next = list1;
    	}
    	if (list2 != null) {
    		cur.next = list2;
    	}
    	return preHead.next;
    }
    public static ListNode getMiddleNode (ListNode head) {
    	ListNode slow = head, fast = head;
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
}
