/*
You have 2 very large binary trees: T1 with millions of nodes, and T2 with hundreds of nodes.
Create an algorithm to decide if T2 is a subtree of T1.
A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
That is, if you cut off the tree at node n, the two trees would be identical.

Space:O(1)
Time:O(n)
*/

public class TreeNode{
	int val;
	TreeNode left,right;
	TreeNode(int val){
		this.val = val;
	}
}

public boolean isSubtree(TreeNode m,TreeNode s){
	// if subtree's root s is null then it is a subtree of main tree m,return true
	if (s == null) return true;
	// if main tree's root is null then it can not have a subree, return false
	if (m == null) return false;
	// check the two trees are identical or not 
	if(check(m,s)) return true;
	
	return isSubtree(m.left,s) || isSubtree(m.right,s);
}

public boolean check(TreeNode p1,TreeNode p2){
	if (p1 == null && p2 == null) return true;
	
	if (p1 != null && p2 != null){
		if (p1.val == p2.val && check(p1.left,p2.left) && check(p1.right,p2.right)){
			return true;
		}
	}
	return false;
}