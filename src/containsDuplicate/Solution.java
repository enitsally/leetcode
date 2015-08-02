package containsDuplicate;

import java.util.*;

public class Solution {

	public boolean containsDuplicate(int[] nums) {

		HashSet<Integer> table = new HashSet<Integer>();

		if (nums == null || nums.length <= 1)
			return false;

		table.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			if (table.contains(nums[i]))
				return true;
			else
				table.add(nums[i]);
		}

		return false;
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		if (nums == null)
			return false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int i = 0, n = nums.length;

		while (i < n) {
			int tmp = nums[i];

			if (map.containsKey(tmp)) {
				int index = map.get(tmp);
				if (i - index <= k)
					return true;
			}
			map.put(tmp, i);
			i++;
		}

		return false;
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
		if (k<1 || t< 0)
			return false;
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for(int i = 0; i< nums.length; i++){
			int tmp = nums[i];
			
			if( (set.floor(tmp) != null && tmp <= set.floor(tmp) +t) ||
				(set.ceiling(tmp) !=null && tmp >= set.ceiling(tmp) -t)	)
				return true;
			
			set.add(tmp);
			if(i>=k)
				set.remove(nums[i-k]);
		}
		return false;
	}

}
