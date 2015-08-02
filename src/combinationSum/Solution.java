package combinationSum;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0)
			return result;

		List<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);

		combinationSum(candidates, target, 0, current, result);
		return result;

	}

	public void combinationSum(int[] candidates, int target, int j,
			List<Integer> curr, List<List<Integer>> result) {
		if (target == 0) {
			List<Integer> temp = new ArrayList<Integer>(curr);
			result.add(temp);
			return;
		}

		for (int i = j; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			curr.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, curr, result);
			curr.remove(curr.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> visit = new ArrayList<Integer>();

		if (candidates == null || candidates.length == 0)
			return result;

		Arrays.sort(candidates);

		combinationSumUnique(candidates, target, 0, visit, result);
		HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);

		// remove duplicate lists
		result.clear();
		result.addAll(set);

		return result;
	}

	public void combinationSumUnique(int[] candidates, int target, int startP,
			List<Integer> visit, List<List<Integer>> result) {
		if (target == 0) {
			List<Integer> temp = new ArrayList<Integer>(visit);
			result.add(temp);
			return;
		}

		for (int i = startP; i < candidates.length; i++) {
			if (target < candidates[i])
				continue;

			visit.add(candidates[i]);
			combinationSumUnique(candidates, target - candidates[i], i + 1,
					visit, result);
			visit.remove(visit.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> visit = new ArrayList<Integer>();
		combinationSumK(nums, k, 0,n,visit,result);
		return result;	
		
	}

	public void combinationSumK(int[] nums,int k, int start, int target,
			List<Integer> visit, List<List<Integer>> result) {

		if (target == 0 && visit.size() == k){
			List<Integer> temp = new ArrayList<Integer>(visit);
			result.add(temp);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if(visit.size() == k)
			    continue;
			if (target < nums[i])
				continue;
			visit.add(nums[i]);
			combinationSumK(nums, k, i + 1, target - nums[i], visit, result);
			visit.remove(visit.size() - 1);;
		}
	}
}
