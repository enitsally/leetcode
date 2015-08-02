package fourSum;

import java.util.*;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 4)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				int sum = target - nums[i];

				for (int j = i + 1; j < nums.length - 2; j++) {

					if (j == i + 1 || nums[j] > nums[j - 1]) {
						int pair = sum - nums[j];

						int start = j + 1;
						int end = nums.length - 1;
						while (start < end) {
							if (nums[start] + nums[end] == pair) {
								List<Integer> tmp = new ArrayList<Integer>();
								tmp.add(nums[i]);
								tmp.add(nums[j]);
								tmp.add(nums[start]);
								tmp.add(nums[end]);

								result.add(tmp);
								start++;
								end--;
								while (start < end
										&& nums[start] == nums[start - 1])
									start++;
								while (start < end
										&& nums[end] == nums[end + 1])
									end--;
							} else if (nums[start] + nums[end] > pair) {
								end--;
							} else {
								start++;
							}
						}
					}

				}
			}
		}

		return result;

	}
	
	public static void main (String[] args){
		Solution s = new Solution();
		int[] nums = new int[]{-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;
		
		System.out.println(s.fourSum(nums, target));
	}
}
