package summaryRanges;

import java.util.*;

public class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();

		if (nums == null || nums.length == 0)
			return result;

		int i = 0, n = nums.length;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		while (i < n) {
			if (queue.isEmpty())
				queue.add(nums[i]);
			else {
				int curr = queue.getLast();

				if (curr + 1 == nums[i]) {
					queue.add(nums[i]);
				}

				else {
					int end = queue.getLast();
					int start = queue.getFirst();
					String tmp = "";
					if (end != start)
						tmp = start + "->" + end;
					else 
						tmp = String.valueOf(start);
					result.add(tmp);
					
					queue = new LinkedList<Integer>();
					queue.add(nums[i]);
				}
			}

			i++;
		}
		
		if (!queue.isEmpty()){
			int end = queue.getLast();
			int start = queue.getFirst();
			String tmp = "";
			if (end != start)
				tmp = start + "->" + end;
			else 
				tmp = String.valueOf(start);
			result.add(tmp);
		}

		return result;
	}
	
	public static void main(String[] arg){
		Solution s = new Solution();
		
		int[] nums = new int[] {0,1};
		
		System.out.println(s.summaryRanges(nums));
	}
}
