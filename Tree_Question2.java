/*
2.Convert a BST into a doubly linkedlist.

Space:O(1)
Time:O(n) - the number of tree nodes
*/

public class TreeNode{
	int val;
	TreeNode left,right;
	TreeNode(int val){
		this.val = val;
	}
}

// use in-order traversal
public class Solution{
	TreeNode root;
	TreeNode head;
	// previous poniter of DLL
	static TreeNode prev = null;
	
	public void BSTToDLL(TreeNode root){
		if (root == null) return;
		
		BSTToDLL(root.left);
		
		// if prev is null, means DLL is null we need to create a head of DLL
		if (prev == null){
			head = root;
		}else{
			// create left and right pointers
			root.left = prev;
			prev.right = root;
		}
		// move prev pointer to next
		prev = root;
		
		BSTToDLL(root.right);
	}
}
	