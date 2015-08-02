package majorityElement;

import java.util.*;

public class Solution {
	public int majorityElementA(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		Arrays.sort(nums);

		int count = 0;
		int p = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == p) {
				count++;
				if (count > (nums.length / 2)) {
					return nums[i];
				}
			} else {
				p = nums[i];
				count = 1;
			}
		}
		
		return 0;
	}
	
	public int majorityElement(int[] nums)
	{
		
		if (nums.length == 1)
			return nums[0];
		
		Arrays.sort(nums);
		
		return nums[nums.length/2];
		
		
	}

}
