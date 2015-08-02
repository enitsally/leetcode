package twoSum;

import java.util.*;

public class twoSum {
	public int[] twoSum(int[] nums, int target) {
				
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for( int i = 0; i< nums.length; i++)
		{
			int x = nums[i];
			if (map.containsKey(target-x))
				return new int[] {map.get(target-x) + 1, i + 1};
			map.put(x, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] arg)
	{
		twoSum ts = new twoSum();
		System.out.println(ts.twoSum(new int[]{2,7,1,8},9));
	}
}
