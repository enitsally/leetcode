package combinationSum;

import java.util.*;

public class Solution2 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();

		Arrays.sort(candidates);

		combination(candidates, target, 0, curr, result);
		return result;

	}

	public void combination(int[] candidates, int target, int begin,
			List<Integer> curr, List<List<Integer>> result) {

		if (target == 0) {
			List<Integer> tmp = new ArrayList<Integer>(curr);
			result.add(tmp);
			return;
		}

		for (int i = begin; i < candidates.length; i++) {

			if (candidates[i] > target)
				return;

			curr.add(candidates[i]);
			combination(candidates, target - candidates[i], i, curr, result);
			curr.remove(curr.size() - 1);

		}

	}
}
