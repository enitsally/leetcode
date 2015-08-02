package largestNumber;

public class SolutionII {
	public String largestNumber(int[] nums) {

		if (nums == null || nums.length == 0)
			return "0";

		quickSort(nums, 0, nums.length - 1);

		String result = "";

		for (int i = 0; i < nums.length; i++) {
			result += Integer.toString(nums[i]);
		}

		return result;

	}

	public boolean isBigger(int a, int b) {
		String sa = Integer.toString(a);
		String sb = Integer.toString(b);

		String ab = sa + sb;
		String ba = sb + sa;

		if (ab.compareTo(ba) > 0)
			return true;
		return false;
	}

	public void quickSort(int[] nums, int begin, int end) {
		int pivot = (begin + end) / 2;
		int i = begin;
		int j = end;

		while (i <= j ) {
			while (isBigger(nums[i],nums[pivot])) {
				i++;
			}

			while (isBigger(nums[pivot],nums[j])) {
				j--;
			}

			if (i <= j) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				i++;
				j--;
			}

		}

		if (begin < j)
			quickSort(nums, begin, j);
		if (i < end)
			quickSort(nums, i, end);
	}
	
	public static void main(String[] args){
		SolutionII s = new SolutionII();
		int[] nums = new int[] {128,12,320,32};
		s.quickSort(nums, 0, 3);
		String tmp = s.largestNumber(nums);
		System.out.println(tmp);
		
	}
}
