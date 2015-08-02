package subSet;

import java.util.*;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null)
			return result;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();

			for (List<Integer> a : result) {
				tmp.add(new ArrayList<Integer>(a));
			}

			for (List<Integer> a : tmp) {
				a.add(nums[i]);
			}

			List<Integer> single = new ArrayList<Integer>();
			single.add(nums[i]);
			tmp.add(single);

			result.addAll(tmp);
		}

		result.add(new ArrayList<Integer>());
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.subsets(new int[] { 1, 2, 3 }));
	}
}
