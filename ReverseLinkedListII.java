package LeetCode;

public class ReverseLinkedListII {
	public static void main (String[] args) {
		ListNode list = new ListNode("1->2->3->4->5");
		list = reverseBetween(list, 1, 5);
		list.print();
	}
	 public static ListNode reverseBetween(ListNode head, int m, int n) {
		 if (head == null || head.next == null || m == n) {
			 return head;
		 }
		 ListNode preNode = null;
		 ListNode curNode = head;
		 ListNode nextNode = head.next;
		 
		 ListNode preChangeFirst = null;
		 ListNode changeFirst = null;
		 for (int i = 2; i <= m; i++) {
			 preNode = curNode;
			 curNode = curNode.next;
			 nextNode = nextNode.next;
		 }
		 preChangeFirst = preNode;
		 changeFirst = curNode;
		 for (int i = m + 1; i <= n; i++) {
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
			nextNode = nextNode.next;
		 }
		 curNode.next = preNode;
		 
		 
		 if (m == 1) {
			 changeFirst.next = nextNode;
			 return curNode;
		 } else {
			 preChangeFirst.next = curNode;
			 changeFirst.next = nextNode;
			 return head;
		 }
	 }
}
