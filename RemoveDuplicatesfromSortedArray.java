package LeetCode;

public class RemoveDuplicatesfromSortedArray {
	public static void main (String[] args) {
		RemoveDuplicatesfromSortedArray test = new RemoveDuplicatesfromSortedArray();
		int[] A = {1,2,2,3,3,3,3,3};
		System.out.println(test.removeDuplicates(A));
	}
	// So elegant, the key point is that, the nth different should be placed in the nth position
	public int removeDuplicates(int[] A) {
		if (A == null) return 0;
		int num = A.length;
		if (num <= 1) return num;
        
		int nthNum = 0;
		for (int i = 1; i < num; i++) {
			if (A[i] != A[i - 1]) {
				nthNum++;
				A[nthNum] = A[i];
			}
		}
		return nthNum + 1;
	}
}
