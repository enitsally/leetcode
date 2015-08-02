package maximumSubarray;

public class Solution {
	public int maxSubArray(int[] nums) {

		int newsum = nums[0];
		int max = newsum;
		for(int i = 1; i < nums.length; i++){
			newsum = Math.max(newsum +nums[i], nums[i]);
			max = Math.max(newsum, max);
		}
	
		return max;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		System.out.println(s.maxSubArray(nums));
	}
}
