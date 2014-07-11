package LeetCode;

public class ReverseInteger {
	public static void main (String[] args) {
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse1(-1234566));
	}
	
	public int reverse(int x) {
		boolean negative = x >= 0 ? false:true;
		String xStr = String.valueOf(x);
		if (negative) {
			xStr = xStr.substring(1);
		}
		int num = xStr.length();
		char[] newStr = new char[num];
		for (int i = 0; i < num; i++) {
			newStr[i] = xStr.charAt(num - i - 1);
		}
		int result = Integer.parseInt(String.valueOf(newStr));
		
		return negative ? result * -1: result;
    }
	
	public int reverse1 (int x) {
		boolean negative = x >= 0 ? false : true;
		if (negative) {
			x = -x;
		}
		int output = 0;
		int mod = 0;
		while (x > 0) {
			mod = x % 10;
			x /= 10;
			output = output * 10 + mod;
		}
		if (negative) {
			output = 0 - output;
		}
		return output;
	}
}
