/*
Question: Given a binary tree and a sum, 
find all root-to-leaf paths where each path's sum equals the given sum.

sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

return : {{5,4,11,2},{5,8,4,5}}

*/

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}

public List<List<Integer>> sumPath(int sum,TreeNode root){
	List<List<Ingeter>> res = new ArrayList<>();
	if (root == null) return res;
	getPath(root,sum,res,new ArrayList<>());
	return res;
}

public void getPath(TreeNode root,int sum,List<List<Ingeter>> res,List<Integer> list){
	if (root.left == null && root.right == null){
		if (root.val == sum){
			list.add(root.val);
			res.add(new ArrayList<>(list));
			list.remove(list.size() - 1)[
		}
		return;
	}
	
	list.add(root.val);
	if (root.left != null){
		getPath(root.left,sum - root.val,res,list);
	}
	if (root.right != null){
		getPath(root.right,sum - root.val,res,list);
	}
	list.remove(list.size() - 1);
}