/*
Given a BST, create a linkedlist of all the nodes at each depth

Space:O(n)
Time:O(n)
*/

public TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}
// use a queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
    	// add root to queue first 
        queue.add(root);
    	
    	//when queue is not empty add tree nodes to the queue
        while(!queue.isEmpty()){
        	// queue size will be the number of each level's nodes
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            
            for (int i = 0;i < size;i++){
            	// dequeue current node, add current node'left and right to the queue
                TreeNode cur = queue.remove();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                
            	// add current node to list
                list.add(cur.val);
            }
        	// add level completed list to outside list
            res.add(list);
        }
        return res;
    }
}