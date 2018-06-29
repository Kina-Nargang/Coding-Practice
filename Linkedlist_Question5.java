/*
5. Implement an algorithm to find the kth to the last element of a singly linked list

Solution: use two pointers.Both pointers will point to head node.
		  First pointer moves to K steps first.
		  use a while loop,move first pointer and second pointer one step at each time
		  when first pointer.next is null then end the while loop.
		  second pointer will point to the Kth-to-last node.
Space:O(1)
Time:O(n)
*/

public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public static ListNode kthToLast(ListNode head,int k){
	if (head == null) return null;
	
	ListNode first = head;
	ListNode second = head;
	
	for (int i = 0;i < k;i++){
		first = first.next;
	}
	
	while(first.next != null){
		first = first.next;
		second = second.next;
	}
	
	return second;
}
			