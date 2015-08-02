package combinationSum;

import java.util.*;
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n){
		
		int [] nums = new int[]{1,2,3,4,5,6,7,8,9};
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		List<Integer> curr = new ArrayList<Integer>();
		
		combination (nums, n, k, 0, curr,result);
		
		return result;
	}
	
	public void combination (int[] nums, int target, int k, int start, List<Integer> curr, List<List<Integer>> result){
		
		if (target == 0 && curr.size() == k){
			List<Integer> tmp = new ArrayList<Integer>(curr);
			result.add(tmp);
			return;
		}
		
		for(int i = start; i < nums.length; i++){
			if (nums[i] > target)
				return;
			curr.add(nums[i]);
			combination(nums, target- nums[i], k, i+1, curr, result);
			curr.remove(curr.size() -1);
		}
	}
}
