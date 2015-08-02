package rotateArray;

public class Solution {
	
	public void rotateA(int[] nums, int k) {

		if (nums == null || nums.length == 0 || k == 0)
			return;
		
		int length = nums.length;
		if (k>length)
		{
			k = k%length;
		}
		for(int i =0; i< k; i++)
		{
			int temp = nums[length-1];
			for (int j = length-1; j > 0; j--)
			{
				nums[j] = nums[j-1];
			}
			nums[0] = temp;
			
		}
		
	}
	
	public void rotateB(int[] nums, int k){
		if (nums == null || nums.length == 0 || k == 0)
			return;
		int length = nums.length;
		int r = k%length;
		
		int[] temp = new int[r];
		
		for(int i = 0; i<r; i++)
		{
			temp[i] = nums[length-r+i];
		}
		
		for(int i = length-r-1; i>=0; i--)
		{
			nums[i+r] = nums[i]; 
		}
		
		for(int i= 0; i<r ;i++)
		{
			nums[i] = temp[i];
		}
	}
	
	public void rotate(int[] nums, int k)
	{
		if (nums == null || nums.length == 0 || k == 0)
			return;
		int length = nums.length;
		k = k%length;
		
		int first = 0;
		int second = length - k;
		
		reverse( nums, first, second-1);
		reverse( nums, second, length-1);
		reverse( nums, first, length-1);
	}
	
	
	public void reverse (int[] nums, int start, int end)
	{
		if(nums.length == 0 || nums == null)
			return;
		
		while(start < end)
		{
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	public static void main (String[] args)
	{
		int[] nums = new int[]{1,2,3,4,5,6,7};
		
		Solution s = new Solution();
		
		s.rotate(nums, 3);
		
		System.out.println(nums);
	}
}
