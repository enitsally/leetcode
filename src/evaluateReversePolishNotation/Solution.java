package evaluateReversePolishNotation;

import java.util.*;

public class Solution {
	public int evalRPN(String[] tokens) {
		if (tokens == null)
			return 0;
		if (tokens.length == 1)
			return Integer.valueOf(tokens[0]);

		LinkedList<String> queue = new LinkedList<String>();
		LinkedList<String> temp = new LinkedList<String>();

		int result = 0;
		for (String s : tokens)
			queue.add(s);

		while (!queue.isEmpty() || !temp.isEmpty()) {
			String one = queue.pop();
			String two = queue.pop();
			String exp = queue.pop();
			String tmp = "";
			while (isInteger(exp)) {
				tmp = one;
				one = two;
				two = exp;
				exp = queue.pop();
				temp.add(tmp);
			}

			switch (exp) {
			case "+":
				result = Integer.valueOf(one) + Integer.valueOf(two);
				break;
			case "-":
				result = Integer.valueOf(one) - Integer.valueOf(two);
				break;
			case "*":
				result = Integer.valueOf(one) * Integer.valueOf(two);
				break;
			case "/":
				result = Integer.valueOf(one) / Integer.valueOf(two);
				break;
			default:
				break;
			}

			if (!queue.isEmpty()) {
				temp.add(String.valueOf(result));
				if (!queue.isEmpty())
					temp.addAll(queue);
				queue = temp;
				temp = new LinkedList<String>();
			}

		}

		return result;
	}

	public boolean isInteger(String s) {

		if (s.equals("-"))
			return false;
		if (s.startsWith("-"))
			s = s.substring(1);

		char[] str = s.toCharArray();

		for (char ch : str) {
			if (!Character.isDigit(ch))
				return false;
		}
		return true;
	}
	
	public int evalRPNII(String[] tokens) {
		Stack<String> stack = new Stack<String>();  
	          
	        for(String s : tokens) {  
	            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {  
	                int second = Integer.parseInt(stack.pop());  
	                int first = Integer.parseInt(stack.pop());  
	                if(s.equals("+")) {  
	                    stack.push(String.valueOf(first+second));  
	                } else if(s.equals("-")) {  
	                    stack.push(String.valueOf(first-second));  
	                } else if(s.equals("*")) {  
	                    stack.push(String.valueOf(first*second));  
	                } else if(s.equals("/")) {  
	                    stack.push(String.valueOf(first/second));  
	                }  
	            } else {  
	                stack.push(s);  
	            }  
	        }  
	          
	        return Integer.parseInt(stack.pop()); 
		}

	public static void main(String[] args) {
		Solution s = new Solution();

		String[] tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*",
				"/", "*", "17", "+", "5", "+" };

		System.out.println(s.evalRPN(tokens));
		// System.out.println(s.isInteger("-6"));
	}
}
