/*
3.Determine if a binary tree is balanced

Note: Each subtrees in given BT should be balanced.
      The differ between right subtree and left subtree can not be more than 1.

Spaca: O(1)
Time: O(n)
*/

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}

public boolean isBalanced(TreeNode root){
	if (root == null) return true;
	// return value -1 means it is not balanced
	if (check(root) < 0) return false;
	return true;
}
public int check(TreeNode root){
	if (root == null) return 0;
	
	int hl = check(root.left);
	int hr = check(root.right);
	
	// if height of left subtree or height of right subtree is already -1 
	// then it is not a balanced return -1
	if (hl = -1 || hr = -1) return -1;
	// if the differ of two subtrees is greater than 1 then it is not a balanced tree return -1
	if (Math.abs(hl - h2) > 1) return -1;
	
	// find the max value of hl and hr, plus 1(root)
	return Math.max(hl,hr) + 1;
}
	