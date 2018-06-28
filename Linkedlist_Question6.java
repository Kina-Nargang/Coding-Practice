/*
6.Implement an algorithm to delete a node a singly linked list, given only access to that node.
*/

public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
class Solution{
	public static void deleteNode(ListNode node){
		// if the node is the last node then it can not be deleted.
		if (node == null || node.next == null) return;
		
		node.val = node.next.val;
		node.next = node.next.next;
	}
}