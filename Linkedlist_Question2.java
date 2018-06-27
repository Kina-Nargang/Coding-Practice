/*
2.Write an algorithm to determine if a linkedlist is circular. FOLLOW UP: Determine where the circle meets.

solution: use two pointers fast and slow.Fast goes two steps, slow goes one step.
		  if they meet then there is a circle.
		  After fast and slow met, use one more poniter called cur points to head.
		  Move slow and cur one step every time, when they meet each other then that
		  node is where the circle begins.
*/

public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		x = val;
		next = null;
	}
}
class solution{
	public static boolean isCircular(ListNode head){
		if (head == null || head.next == null) return false;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null){
			fast = fase.next.next;
			slow = slow.next;
			if (fast == slow) return true;
		}
		return false;
	}
}

//FOLLOW UP: if there is no circle then return null
class solution{
	public static ListNode circuleMeet(ListNode head){
		if (head == null || head.next == null) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null){
			fast = fase.next.next;
			slow = slow.next;
			// if there is a circle
			if (fast == slow){
				ListNode cur = head;
				while (cur != slow){
					cur = cur.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}
