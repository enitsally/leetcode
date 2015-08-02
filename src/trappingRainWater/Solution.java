package trappingRainWater;

public class Solution {
	public int trap(int[] height) {
		if (height == null || height.length <= 2)
			return 0;

		int left = 0;
		while (left < height.length) {
			if (height[left] == 0)
				left++;
			else
				break;
		}
		int right = left + 2;
		int trap = 0;

		while (left < height.length && right < height.length && left < right) {
			while (right < height.length) {
				if (height[right] < height[left])
					right++;
				else
					break;
			}

			if (left == height.length - 3)
				break;

			if (right == height.length) {
				left = left + 1;
				right = left + 2;
			} else {
				int w = right - left - 1;
				int h = height[left];
				int curr = w * h;

				int i = left + 1;
				while (i < right) {
					curr = curr - height[i];
					i++;
				}

				trap = trap + curr;
				left = right;
				right = left + 2;
			}

		}

		return trap;
	}

	public int trapII(int[] height) {

		if (height == null || height.length == 0)
			return 0;
		int[] left = new int[height.length];
		int[] right = new int[height.length];

		left[0] = height[0];
		for (int i = 1; i < height.length; i++)
			left[i] = Math.max(left[i - 1], height[i]);

		right[height.length - 1] = height[height.length - 1];

		for (int i = height.length - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], height[i]);

		int sum = 0;

		for (int i = 1; i < height.length - 1; i++) {
			sum += Math.min(left[i], right[i]) - height[i];
		}

		return sum;

	}

	public int trapIII(int[] height) {
//		if (height == null || height.length == 0)
//			return 0;
//		int l = 0;
//		int r = height.length - 1;
//		int res = 0;
//		while (l < r) {
//			int min = Math.min(height[l], height[r]);
//			if (height[l] == min) {
//				l++;
//				while (l < r && height[l] < min) {
//					res += min - height[l];
//					l++;
//				}
//			} else {
//				r--;
//				while (l < r && height[r] < min) {
//					res += min - height[r];
//					r--;
//				}
//			}
//		}
//		return res;
		
		if (height == null || height.length == 0)
			return 0;
		
		int left = 0;
		int right = height.length-1;
		int sum = 0;
		while (left < right){
			int min = Math.min(height[left], height[right]);
			
			if (height[left] == min){
				left++;
				while (left < right && height[left]< min){
					sum+= min - height[left];
					left++;
				}
			}
			else{
				right--;
				while (left<right && height[right]<min){
					sum+= min - height[right];
					right--;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		System.out.println(s.trapIII(height));
	}
}
