package subSet;

import java.util.*;

public class SolutionII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return result;

		List<List<Integer>> tmp = new ArrayList<List<Integer>>();
		int i = 0, n = nums.length;
		
		while (i < n) {
			if (!result.isEmpty()){
				tmp = new ArrayList<List<Integer>>();
				for (List<Integer> ele : result){
					tmp.add(ele);
				}
			}
			
			
			if (!tmp.isEmpty()){
				List<List<Integer>> add = new ArrayList<List<Integer>>();
				for(List<Integer> ele : tmp){
					List<Integer> a = new ArrayList<Integer>(ele);
					a.add(nums[i]);
					add.add(a);
				}
				tmp.addAll(add);
				
			}
			
			List<Integer> self = new ArrayList<Integer>();
			self.add(nums[i]);
			
			if (!tmp.contains(self))
				tmp.add(self);
			result = new ArrayList<List<Integer>>(tmp);
			i++;
		}
		
		result.add(new ArrayList<Integer>());

		return result;

	}
	
	public static void main (String[] args){
		SolutionII s = new SolutionII();
		int[] nums = new int[]{1,1};
		System.out.println(s.subsetsWithDup(nums));
	}
}
