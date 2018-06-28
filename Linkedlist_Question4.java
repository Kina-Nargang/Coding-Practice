/*
4.Write code to remove duplicates from an unsorted linked list.
  Follow up: How would you solve it if temporary buffer is not allowed?
*/

public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
// Use hashset.Space:O(n),Time:O(n)
class Solution{
	public static void removeDuplicates(ListNode head){
		if (head == null || head.next == null) return;
		
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode cur = head;
		
		while(cur != null && cur.next.next != null){
			if (set.containsKey(cur.val)){
				cur.next = cur.next.next;
			}else{
				set.add(cur.val);
				cur = cur.next;
			}
		}
	}
}
// Use two loops.Space:O(1),Time:O(n^2)
class Solution{
	public static void removeDuplicates(ListNode head){
		if (head != null || head.next.next != null) return;
		
		ListNode cur = head;
		
		while (cur != null){
			ListNode runner = cur;
			while(runner.next != null){
				if (runner.next.val == cur.next.val){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			cur = cur.next;
		}
	}
}
				
