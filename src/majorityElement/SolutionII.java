package majorityElement;
import java.util.*;

public class SolutionII {
	public List<Integer> majorityElement(int[] nums) {

		List<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return result;
		if (nums.length == 1){
			result.add(nums[0]);
			return result;
		}

		int i = 0, n = nums.length;
		int k = n / 3;

		Arrays.sort(nums);
		while (i < n && i + k < n) {
			if (k == 0){
				if (!result.contains(nums[i]))
					result.add(nums[i]);
			}
			else if (nums[i] == nums[i + k ]) {
				if (!result.contains(nums[i]))
					result.add(nums[i]);

			}
			i++;

		}

		return result;
	}
	
	public static void main(String[] arg){
		SolutionII s = new SolutionII();
		int[] nums = new int[]{1,2};
		
		System.out.println(s.majorityElement(nums));
	}
}
