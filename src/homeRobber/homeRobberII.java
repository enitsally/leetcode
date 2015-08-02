package homeRobber;

public class homeRobberII {

	public int rob(int[] nums) {

		if (nums.length == 0 || nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];

		if (nums.length == 2)
			return nums[0] > nums[1] ? nums[0] : nums[1];

		int withFirst = CalSum(nums, 0, nums.length - 1);
		int withOut = CalSum(nums, 1, nums.length);

		return withFirst > withOut ? withFirst : withOut;

	}

	public int CalSum(int[] nums, int start, int end) {
		int even = 0;
		int odd = 0;

		for (int i = start; i < end; i++) {
			if (i % 2 == 0) {
				even += nums[i];
				even = even > odd ? even : odd;
			} else {
				odd += nums[i];
				odd = even > odd ? even : odd;
			}
		}

		return (even > odd ? even : odd);

	}

}
