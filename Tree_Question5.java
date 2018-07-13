/*
Implement a function to check if a binary tree is a BST

Space: O(1)
Time:O(n) - n is the number of BST's nodes
*/

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}

public boolean isBST(TreeNode root,int min,int max){
	if (root == null) return true;
	
	if (root.val <= min || root.val > max) return false;
	
	// for the left subtree,root.val will be max value
	// for the right subtree,root.val will be min value
	return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
}
	