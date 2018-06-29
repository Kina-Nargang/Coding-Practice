/*
3.Clone a linked list with a random pointer.

Solution: Use hashmap
Space: O(n)
Time: O(n)
*/

public class ListNode{
	int val;
	ListNode next,random;
	ListNode(int x){
		val = x;
		next = random = null;
	}
}

//Solution1:
public static ListNode randomClone(ListNode head){
	if (head == null) return;
	
	HashMap<ListNode,ListNode> map = new HashMap<>();
	ListNode cur = head;
	
	while(cur != null){
		map.add(cur,new ListNode(cur.val));
		cur = cur.next;
	}
	cur = head;
	
	while(cur != null){
		/* linkedlist: 1 -> 2 -> 3
			map will be:
				old		new
				 1		 1'
				 2		 2'
				 3		 3'
		if cur = 1 then map.get(cur).next = 1'.next
						map.get(cur.next) = 2'
		so the new linkedlist will be: 1' -> 2'
		*/
		map.get(cur).next = map.get(cur.next);
		/* linkedlist: 1 -> 2 -> 3
						 -> 3 (1 points to 2, random points to 3)
			map will be:
				old		new
				 1		 1'
				 2		 2'
				 3		 3'
		if cur = 1 then map.get(cur).random = 1'.random
						map.get(cur.random) = 3'
		so the new linkedlist will be: 1' -> 2'
										  -> 3'
		*/
		map.get(cur).random = map.get(cur.random);
		// go to next node
		cur = cur.next;
	}
	return map.get(head);
}
	
	