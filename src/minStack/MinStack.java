package minStack;

import java.util.*;

public class MinStack {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minValue = new Stack<Integer>();

	public void push(int x) {
		stack.push(x);

		if (minValue.isEmpty())
			minValue.push(x);
		else {
			int min = minValue.peek();
			if (x >= min)
				minValue.push(min);
			else
				minValue.push(x);
		}
	}

	public void pop() {
		stack.pop();
		minValue.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minValue.peek();
	}
	
	public static void main(String[] args){
		MinStack m = new MinStack();
		
		m.push(2);
		m.push(0);
		m.push(3);
		m.push(0);
	}

}
