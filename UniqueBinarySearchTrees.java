package LeetCode;

public class UniqueBinarySearchTrees {
	public static void main (String[] args) {
		UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
		System.out.println(test.numTrees(4));
	}
	public int numTrees(int n) {
		if (n == 0) return 1;
		if (n == 1 || n == 2) return n;
		int sum = 0;
        for (int i = 0; i < n / 2; i++) {
        	sum += numTrees(i) * numTrees(n - i - 1);
        }
        if (n % 2 == 0) {
        	return sum * 2;
        } else {
        	return sum * 2 + numTrees(n / 2) * numTrees(n / 2);
        }
        
    }
}
