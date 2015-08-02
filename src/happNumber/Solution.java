package happNumber;

import java.util.*;

public class Solution {

	public boolean isHappy(int n) {
		
		HashSet<Integer> map = new HashSet<Integer>();
		
		while (n!=1)
		{
			n = getSquareSum(n);
			if (map.contains(n))
				return false;
			else 
				map.add(n);
		}
		
		return true;
		
		
	}
	
	public int getSquareSum(int n)
	{
		int sum = 0;
		
		while(n!=0)
		{
			int temp = n%10;
			sum += temp*temp;
			n = n/10;
		}
		
		return sum;
	}

}
