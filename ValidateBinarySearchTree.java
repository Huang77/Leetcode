package LeetCode;

public class ValidateBinarySearchTree {
	public static void main (String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.left.left = new TreeNode(1);
		System.out.println(isValidBST(root));
	}
	
	public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, -Integer.MAX_VALUE, Integer.MAX_VALUE);       
    }
	public static boolean isValidBST (TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			if (root.val < max && root.val > min) {
				return true;
			}
		} 
		int temp;
		boolean left = true, right = true;
		if (root.left != null) {
			temp = root.left.val;
			if (temp >= root.val || temp <= min) {
				return false;
			} else {
				left = isValidBST(root.left, min, root.val);
			}
		}
		if (root.right != null) {
			temp = root.right.val;
			if (temp >= max || temp <= root.val) {
				return false;
			} else {
				right = isValidBST(root.right, root.val, max); 
			}
		}
		return left && right;
	}
}
