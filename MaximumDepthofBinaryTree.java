package LeetCode;

public class MaximumDepthofBinaryTree {
	public static void main (String[] args) {
		MaximumDepthofBinaryTree test = new MaximumDepthofBinaryTree();
		TreeNode r = test.new TreeNode(2);
		TreeNode lc = test.new TreeNode(3);
		TreeNode rc = test.new TreeNode(4);
		r.left = lc;
		lc.right = rc;
		
		System.out.println(test.maxDepth(r));
	}
	
	 // Definition for binary tree
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	 public int maxDepth(TreeNode root) {
		 if (root == null) return 0;
         int lDepth, rDepth;
		 if (root.left != null) {
			 lDepth = 1 + maxDepth(root.left);
		 } else {
			 lDepth = 1;
		 }
		 if (root.right != null) {
			 rDepth = 1+ maxDepth(root.right);
		 } else {
			 rDepth = 1;
		 }
		 if (lDepth > rDepth) {
			 return lDepth;
		 } else {
			 return rDepth;
		 }
	 }
}
