/*
9.Given a singly linked list which has data sorted in ascending order, construct a balanced BST.
*/

//Definition for a binary tree node.
public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
//Definition for singly-linked list.
public class ListNode{
	int val
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
class Solution{
	public static TreeNode linkedListToBST(ListNode head){
		if (head == null) return null;
		return BST(head,null);
	}
	
	public TreeNode BST(ListNode head,ListNode tail){
		if (head == tail) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		
		//find the middle node in the linkedlist
		while (fast != tail && fast.next.next != tail){
			fast = fast.next.next;
			slow - slow.next;
		}
		
		// use middle node to create BST's root
		TreeNode root = new TreeNode(slow);
		// use left half of linkedlist's nodes to create left side of BST
		root.left = BST(head,slow);
		// use right half of linkedlist's nodes to create right side of BST
		root.right = BST(slow.next,tail);
		
		return root;
	}
}