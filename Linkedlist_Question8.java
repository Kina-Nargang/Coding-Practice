/*
8.Reverse a linked list ? iteratively and recursively
*/

public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		x = val;
		next = null;
	}
}
// iteratively:
public static ListNode reverseLinkedlist(ListNode head){
	if (head == null || head.next == null) return head;
	
	ListNode prev = null;
	ListNode cur = head;
	ListNode next = null;
	
	while(cur != null){
		next = cur.next;
		cur.next = prev;
		prev = cur;
		cur = next;
	}
	head = prev;
	return head;
}
// recursively:
public static ListNode reverseLinkedlist(ListNode head){
	if (head == null || head.next == null) return head;
	
	ListNode node = reverseLinkedlist(head.next);
	head.next.next = head;
	head.next = null;
	
	return node;
}
