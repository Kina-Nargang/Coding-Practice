/*
Given a sorted array, create a binary search tree with minimal height
*/

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}
class Solution{
	public TreeNode sortedArrayToBST(int[] nums){
		if (nums == null || nums.length == 0) return null;
		return createBST(nums,0,nums.length - 1);
	}
	public TreeNode createBST(int[] nums,int start,int end){
		if (start > end) return null;
		int mid = (end - start)/2 + end;
		
		TreeNode root = new TreeNode(nums[mid]);
		TreeNode root.left = createBST(nums,start,mid - 1);
		TreeNode root.right = createBST(nums,mid + 1,end);
		
		return root;
	}
}
	