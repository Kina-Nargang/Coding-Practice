/*
3.Clone a linked list with a random pointer.
*/

public class ListNode{
	int val;
	ListNode next,random;
	ListNode(int x){
		val = x;
		next = random = null;
	}
}

//Solution1:using hashmap space:O(n),Time: O(2n)
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

//Solution2: without using extra space. Space:O(1),TimeO(3n)

public static ListNode randomClone(ListNode head){
	if (head == null) return;
	
	ListNode cur = head;
	
	// copy nodes and insert copied nodes into linkedlist
	while(cur != null){
		ListNode copy = new ListNode(cur.val);
		copy.next = cur.next;
		cur.next = copy;
		cur = cur.next.next;
	}
	
	//copy random pointers
	cur = head;
	while(cur != null){
		// if orignal random pointers exist
		if (cur.random != null){
			cur.next.random = cur.random.next;
		}
		cur = cur.next.next;
	}
	
	// break linkedlist
	cur = head;
	ListNode newhead = head.next;
	while(cur != null){
		ListNode temp = cur.next;
		cur.next = temp.next;
		if (temp.next != null){
			temp.next = temp.next.next;
		}
		cur = cur.next;
	}
	
	return newhead;
}