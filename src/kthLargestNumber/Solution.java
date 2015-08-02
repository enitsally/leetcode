package kthLargestNumber;

import java.util.*;

public class Solution {

	public int findKthLargestA(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return -1;

		Arrays.sort(nums);

		/*
		 * int max = 0; int pointer = 0;
		 * 
		 * for (int i = nums.length - 1; i >= 0; i--) { if (nums[i] == max)
		 * continue; else { max = nums[i]; pointer++; }
		 * 
		 * if (pointer == k) break; }
		 */

		return nums[nums.length - k];
	}

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return -1;

		int len = nums.length;
		
		Heap h = new Heap(len);
		
		for(int num : nums)
			h.insert(num);
		
		int max=0;
		for(int i = 0; i< k; i++)
		{
			max= h.remove().getKey();
		}
		return max;

	}
}
