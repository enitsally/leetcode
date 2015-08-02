package twoSum;

import java.util.*;

public class twoSumStructure {

	Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	
	public void add(int input)
	{
		int count = map.containsKey(input)? map.get(input) : 0;
		map.put(input, count+1);
	}
	
	public boolean find(int val)
	{
		for(Map.Entry<Integer, Integer> entry: map.entrySet())
		{
			int num = entry.getKey();
			int y = val - num;
			
			if (y == num)
			{
				if (entry.getValue() >= 2)
					return true;
			}
			else if (map.containsKey(y))
			{
				return true;
			}
		}
		return false;
	}
}
