package singleNumber;

import java.util.*;

public class Solution {
	public int singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int num : nums) {
			if (!set.add(num))
				set.remove(num);
		}

		Iterator<Integer> it = set.iterator(); 
		return it.next();

		// int x = 0;
		// for(int num : nums){
		// x = x^num;
		// }
		// return x;
	}

	public int singleNumberII(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int num : nums) {
			if (map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);
		}
		int result = 0;

		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			if (entry.getValue() != 3)
				result = entry.getKey();
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int[] nums = new int[] { 2, 2, 3, 2 };

		System.out.println(s.singleNumberII(nums));
	}
}
