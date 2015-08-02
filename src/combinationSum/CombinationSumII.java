package combinationSum;

import java.util.*;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		Arrays.sort(candidates);
		
		combinationSum(candidates,target,0,curr,result);
		
		HashSet<List<Integer>> f = new HashSet<List<Integer>>();
		
		for(List<Integer> tmp : result)
		{
			if (!f.contains(tmp))
				f.add(tmp);
		}
		
		result.clear();
		
		for(List<Integer> i : f){
			result.add(i);
		}
		
		return result;
	}
	
	public void combinationSum (int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result){
		
		if (target == 0)
		{
			List<Integer> tmp = new ArrayList<Integer>(curr);
			result.add(tmp);
			return;
		}
		
		for(int i = start; i< candidates.length; i++){
			
			if (candidates[i] > target)
				return;
			curr.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i+1, curr, result);
			curr.remove(curr.size()-1);
			
		}
	}

}
