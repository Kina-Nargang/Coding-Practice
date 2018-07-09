/*
1.Write an algorithm to find the next node (i.e in-order successor) of a given node in a binary search tree.
  You may assume that each node has a link to its parent
  
Solution:
	Case1: If the given node dose have a right subtree then find the most-left node of this right subtree.
	Case2: if the given node dose not have a right subtree then while searching the given node in the BST,
		store the last parent node that gose to left.The last parent node will be the inorder successor.

Space: O(1)
Time: O(h) - h is the height of BST
*/

public class TreeNode{
	int val;
	TreeNode right;
	TreeNode left;
	TreeNode(int x){
		val = x;
	}
}

public class Solution{
	public TreeNode findInorderSuccessor(TreeNode root,TreeNode node){
		// if root is null or given node is null then return null;
		if (root == null || node == null) return null;
		
		TreeNode successor = null;
		
		//case1: if given node has right subtree
		//also works then it is a binary tree
		if (node.right != null){
			TreeNode cur = node.right;
			while(cur.left != null){
				cur = cur.left;
			}
			successor = cur;
		}else{
			// case2: if given node does not have a right subtree
			TreeNode successor = null;
			TreeNode p = root;
			while (p != null){
				if (node.val < p.val){
					successor = node;
					p = p.left;
				}else{
					p = p.right;
				}
			}
		}
		
		return successor;
	}
}