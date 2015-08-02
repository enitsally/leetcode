package stackUsingQueue;

import java.util.*;

public class MyStack {
	Queue<Integer> normalQ = new LinkedList<Integer>();
	Queue<Integer> reverseQ = new LinkedList<Integer>();
	
	public void push(int x)
	{
		if (!reverseQ.isEmpty())
		{
			int m = reverseQ.poll();
			normalQ.offer(m);
		}
		
		normalQ.offer(x);
	}
	
	public void pop(){
		move();
		reverseQ.poll();
	}
	
	public int top(){
		move();
		return reverseQ.peek();
	}
	
	public boolean empty()
	{
		return normalQ.isEmpty() && reverseQ.isEmpty();
	}
	
	public void move()
	{
		if (reverseQ.isEmpty())
		{
			while (normalQ.size() > 1)
			{
				reverseQ.offer(normalQ.poll());
			}
			Queue<Integer> tmp = reverseQ;
			reverseQ = normalQ;
			normalQ = tmp;
		}
	}
}
