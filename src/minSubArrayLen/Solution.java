package minSubArrayLen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	/**
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen_old(int s, int[] nums) {

		int length = nums.length;

		for (int window = 1; window <= length; window++) {
			for (int start = 0; start < length; start++) {
				int sum;
				int end = start + window;

				if (end < length - 1) {
					sum = getSum(nums, start, end - 1);
					if (sum >= s) {
						return window;
					}
				}

			}
		}

		return 0;
	}

	public int minSubArrayLen(int s, int[] nums) {

		int left = 0;
		int right = nums.length;
		int mid = 0;
		int best = 0;
		while (left <= right) {
			mid = (right + left) / 2;
			if (findSum(s, nums, mid)) {
				best = mid;
				right = mid - 1;
			} else
				left = mid + 1;
		}
		return best;
	}

	public boolean findSum(int s, int[] nums, int len) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i >= len) {
				sum -= nums[i - len];
			}
			if (sum >= s) {
				return true;
			}
		}
		return false;
	}

	public int getSum(int[] nums, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += nums[i];
		}
		return sum;
	}

	public static void main(String[] arg) throws NumberFormatException,
			IOException {
		String line;
		String[] str_input;
		Solution solution = new Solution();

		System.out
				.println("Enter the array with comma seperator, 'q' to exit.");
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		while ((line = stdin.readLine()) != null && line.length() != 0) {
			System.out
					.println("Enter the array with comma seperator, 'q' to exit.");

			if (line.equalsIgnoreCase("q")) {
				System.out.println("Quit!!");
				System.exit(0);
			} else {
				str_input = line.split(",");
				int[] int_inputs = new int[str_input.length];
				int i = 0;
				for (String input : str_input) {
					int_inputs[i] = Integer.parseInt(input);
					i++;
				}
				int result = solution.minSubArrayLen(11, int_inputs);
				System.out.println(result);
			}
		}
		System.exit(0);
	}
}
