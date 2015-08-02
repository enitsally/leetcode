package threeSumClosest;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return Integer.MIN_VALUE;

		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2]-target;		
		
		for(int i = 0 ; i < nums.length -2; i++){
			int cur = twoSum(nums,i+1,target-nums[i]);
			
			if (Math.abs(cur) < Math.abs(closest))
				closest = cur;
		}
		
		return target + closest;

	}

	public int twoSum(int[] nums, int start, int target) {
		int closest = nums[start] + nums[start + 1] - target;

		int l = start;
		int r = nums.length - 1;

		while (l < r) {
			if (nums[l] + nums[r] == target)
				return 0;
			
			int diff = nums[l] + nums[r] - target;
			
			if (Math.abs(diff) < Math.abs(closest))
				closest = diff;
			
			if (nums[l] + nums[r] > target)
				r--;
			else
				l++;
		}
		
		return closest;
		//Comment test
	}
}
