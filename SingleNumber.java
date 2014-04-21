/* 一个整数数组，其中只有一个元素只出现一次，其他元素都出现两次，请找到这个出现一次的数*/
/* 线性时间，并且不需要用额外的空间*/

/* 因为A^B^A=B, 所以对数组进行一次异或就可以得到只出现一次的数 */

public class SingleNumber {
	public int findSingle (int[] A) {
		for (int i = 1; i < A.length; i++) {
			A[i] ^= A[i-1];
		}
		return A[A.length];
	}
}
