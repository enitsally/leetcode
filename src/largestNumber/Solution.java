package largestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public String largestNumber(int[] nums) {

		if (nums.length == 0)
			return null;

		String[] str_nums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			str_nums[i] = Integer.toString(nums[i]);
		}

		Arrays.sort(str_nums, new myComparator());

		StringBuilder sb = new StringBuilder();
		for (int i = str_nums.length - 1; i >= 0; i--) {
			sb.append(str_nums[i]);
		}

		int i = 0;
		while (i < str_nums.length && sb.charAt(i) == '0') {
			i++;
		}

		if (i == str_nums.length)
			return "0";
		return sb.toString().substring(i);
	}

	public class myComparator implements Comparator<String> {

		public int compare(String a, String b) {
			String ab = a + b;
			String ba = b + a;
			return ab.compareTo(ba);
		}

	}

//	public String largestNumber(int[] nums) {
//
//		if (nums == null)
//			return "";
//		if (nums.length == 1)
//			return Integer.toString(nums[0]);
//
//		nums = quickSort(nums, 0, nums.length - 1);
//		String result = "";
//
//		for (int i = 0; i < nums.length; i++) {
//			result += Integer.toString(nums[i]);
//		}
//
//		return result;
//
//	}
//
//	public boolean isBigger(int a, int b) {
//		boolean result = false;
//
//		String sa = Integer.toString(a);
//		String sb = Integer.toString(b);
//
//		String ab = sa + sb;
//		String ba = sb + sa;
//
//		if (ab.compareTo(ba) > 0)
//			result = true;
//		return result;
//	}
//
//	public int[] quickSort(int[] nums, int low, int high) {
//
//		int pivot = low + (high - low) / 2;
//		int i = low;
//		int j = high;
//
//		while (i <= j) {
//			while (isBigger(nums[i], nums[pivot])) {
//				i++;
//			}
//			while (isBigger(nums[pivot], nums[j])) {
//				j--;
//			}
//			if (i <= j) {
//				int temp = nums[j];
//				nums[j] = nums[i];
//				nums[i] = temp;
//				i++;
//				j--;
//			}
//		}
//
//		if (low < j)
//			quickSort(nums, low, j);
//		if (i < high)
//			quickSort(nums, i, high);
//
//		return nums;
//	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int[] nums = new int[] { 128,12,320,32 };
		System.out.println(s.largestNumber(nums));
	}

}
