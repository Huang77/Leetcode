import java.util.Stack;


public class EvaluateReversePolishNotation {
	public static void main (String[] args) {
		//String[] tokens = {"2", "1", "+", "3", "*"};
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
	}
	
	public int evalRPN(String[] tokens) {
		String operations = "+-/*";
		Stack<String> operands = new Stack<String>();
		int index, a, b, c = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (!operations.contains(tokens[i])) {
				operands.push(tokens[i]);
			} else {
				index = operations.indexOf(tokens[i]);
				a = Integer.parseInt(operands.pop());
				b = Integer.parseInt(operands.pop());
				switch (index) {
				case 0: c = a + b; break;
				case 1: c = a - b; break;
				case 2: c = b / a; break;
				case 3: c = a * b; break;
				}
				operands.push(String.valueOf(c));
			}
		}
		
		return Integer.parseInt(operands.pop());
    }
}
