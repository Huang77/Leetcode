package LeetCode;

public class SameTree {
	public static void main (String[] args) {
		SameTree test = new SameTree();
		TreeNode r = test.new TreeNode(2);
		
		TreeNode lc = test.new TreeNode(3);
		TreeNode rc = test.new TreeNode(3);
		
		lc.left = r;
		rc.right = r;

		
		System.out.println(test.isSameTree(lc, rc));
	}
	
	 // Definition for binary tree
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 if (p == q) return true;
		 if (p == null || q == null) return false;
		 
		 boolean lSame, rSame;
		 if (p.left != null && q.left != null) {
			 lSame = isSameTree(p.left, q.left);
		 } else if (p.left == null && q.left == null) {
			 lSame = (p.val == q.val);
		 } else {
			 lSame = false;
		 }
		 
		 if (p.right != null && q.right != null) {
			 rSame = isSameTree(p.right, q.right);
		 } else if (p.right == null && q.right == null) {
			 rSame = (p.val == q.val);
		 } else {
			 rSame = false;
		 }
		 
		 return lSame && rSame;
		  
	 }
	 
	 public boolean isSameTree2 (TreeNode p, TreeNode q) {
		 if (p == null && q == null) {
			 return true;
		 } else if (p != null && q != null) {
			 if (p.val == q.val) {
				 return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
			 } else {
				 return false;
			 }
		 } else {
			 return false;
		 }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
