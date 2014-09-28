package LeetCode;

public class InsertionSortList {
	public static void main (String[] args) {
		ListNode head = new ListNode("5->1");
		head = insertionSortList(head);
		head.print();
	}
	 public static ListNode insertionSortList(ListNode head) {
		 if (head == null || head.next == null) {
			 return head;
		 }
		 ListNode newHead = new ListNode(0);
		 newHead.next = head;
		 
		 ListNode curNode = head.next;
		 ListNode cursor = newHead;
		 ListNode nextNode;
		 newHead.next.next = null;
		 
		 while (curNode != null) {
			 cursor = newHead;
			 nextNode = curNode.next;
			 while (cursor.next != null) {
				 if (cursor.next.val > curNode.val) {
					 ListNode temp = cursor.next;
					 cursor.next = curNode;
					 cursor.next.next = temp;;
					 break;
				 }
				 cursor = cursor.next;
			 }
			 if (cursor.next == null) {
				 cursor.next = curNode;
				 cursor.next.next = null;
			 }
			 curNode = nextNode;
		 }
		 return newHead.next;
	 }
}
