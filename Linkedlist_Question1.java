/*
1.Write an algorithm to determine if a linkedlist is a palindrome 
 -- The two solutions below only need to compare half of the linked list and need to take care the numbers of the linked list nodes,
    even or odd.

solution1: use a stack. Run time: O(n), Space:O(n);
			
solution2: reverse the linked list and compare the reversed linked list and original linked list.
		   For this solution, we only need to reverse half of the linked list then compare with the other half
		   of the original linked list.
		   Run time:O(n), Space:O(1);
		   
Solution2 has better space complexity than solution1 so I will use solution2.
*/
public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        
        // split linkedlist into half
        ListNode cur = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode head_sec = null;
        
        while (cur != null){
            fast = fast.next.next;
            // odd length - ignore the middle node and set the new head
            if (fast.next == null){
                head_sec = slow.next.next;
                break;
            // even length
            }else if (fast == null){
                head_sec = slow.next;
                break;
            }
            slow = slow.next;
        }
        slow.next = null;
        
        ListNode reversed_head = reverse(head_sec);
        
        while (cur != null){
            if (cur.val != reversed_head.val){
                return false;
            }
            cur = cur.next;
            reversed_head = reversed_head.next;
        }
        return true;
    }
    
    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
        return head;
    }
}
