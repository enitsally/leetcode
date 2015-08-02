package threeSum;

import java.util.*;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 0)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			// avoid duplicated
			if (i == 0 || nums[i] > nums[i - 1]) {
				int tmp = nums[i];
				int target = 0 - tmp;

				int start = i + 1;
				int end = nums.length - 1;

				while (start < end) {
					if (nums[start] + nums[end] == target) {
						List<Integer> lst = new ArrayList<Integer>();
						lst.add(tmp);
						lst.add(nums[start]);
						lst.add(nums[end]);

						result.add(lst);

						start++;
						end--;
						// avoid duplicate solutions
						while (start < end && nums[start - 1] == nums[start])
							start++;
						while (start < end && nums[end] == nums[end + 1])
							end--;
					} else if (nums[start] + nums[end] < target)
						start++;
					else
						end--;

				}
			}

		}

		return result;
	}
}
