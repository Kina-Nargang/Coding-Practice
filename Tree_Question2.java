/*
2.Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
  Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a BST
  
Space:O(1)
Time:O(n) - n is the number of the tree nodes
*/


public class TreeNode{
	int val;
	TreeNode right;
	TreeNode left;
	TreeNode(int x){
		val = x;
	}
}

public TreeNode findLCA(TreeNode root,TreeNode p,TreeNode q){
	if (root == null) return null;
	if (root == p || root == q) return root;
	
	TreeNode left = findLCA(root.left,p,q);
	TreeNode right = findLCA(root.right,p,q);
	
	if (left != null && right != null) return root;
	if (left == null && right == null) return null;
	return right != null ? right : left;
}