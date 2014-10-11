package LeetCode;

public class RemoveDuplicatesfromSortedListII {
	public static void main (String[] args) {
		ListNode head = new ListNode("1->2->2");
		head = deleteDuplicates(head);
		head.print();
	}
	
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        ListNode curNode = head;
        boolean flag = false;
        
        while (curNode != null) {
        	flag = false;
        	while(curNode != null && curNode.next != null && curNode.val == curNode.next.val) {
        		curNode = curNode.next;
        		flag = true;
        	}
        	if (flag != true) {
        		temp.next = curNode;
        		temp = temp.next;
        	}
        	curNode = curNode.next;
        }
        temp.next = null;
        return newHead.next;
    }
}
