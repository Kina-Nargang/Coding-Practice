/*
7.Write code to partition a linkedlist around a value x, such that all nodes less than x come before all nodes great than or equal to x

Solution: create two linked lists. One is for smaller than x, the other is for bigger or equal to x.
		  Connect two linked lists.

Space: O(n)
Time: O(n)
*/

public class ListNode{
	int val;
	ListNode next;
	ListNode(int y){
		val = y;
	}
}

public static ListNode PartitionALinkedlist(ListNode head,int x){
	if (head == null) return null;
	
	ListNode shead = new ListNode(0);
	ListNode bhead = new ListNode(0);
	ListNode s = shead;
	ListNode b = bhead;
	
	while(head != null){
		// copy nodes
		ListNode temp = new ListNode(head.val);
		if (head.val < x){
			s.next = temp;
			s = s.next;
		}else{
			b.next = temp;
			b = b.next;
		}
		head = head.next;
	}
	// connect two linked lists
	s.next = bhead.next;
	return shead.next;
}