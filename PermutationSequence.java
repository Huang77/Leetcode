package LeetCode;

public class PermutationSequence {
	public static void main (String[] args) {
		int n = 3;
		int k = 3;
		System.out.println(getPermutation(n, k));
	}
	
	public static String getPermutation(int n, int k) {
		int[] num = new int[n];
		int base = 1;
		num[0] = 1;
		for (int i = 1; i < n; i++) {
			num[i] = i + 1;
			base = base * num[i];
		}
		k--;
		StringBuffer newStr = new StringBuffer();
		int index;
		for (int i = n - 1; i >= 0; i--) {
			base = base / (i + 1);
			index = k / base;
			newStr.append(num[index]);
			k = k % base;
			for (int j = index; j < i; j++) {
				num[j] = num[j + 1];
			}
		}
		return newStr.toString();
    }
	
	

}
