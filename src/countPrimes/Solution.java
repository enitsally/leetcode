package countPrimes;

import java.util.*;

public class Solution {

	public int countPrimes(int n) {
		if (n <= 2)
			return 0;

		List<Integer> prims = new ArrayList<Integer>();
		int[] nums = new int[n - 1];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 2;
		}

		int pointer = 2;

		while (pointer != 0) {
			prims.add(pointer);
			for (int s = pointer; s < n; s++) {
				if (s % pointer == 0) {
					nums[s - 2] = 0;
				}
			}
			pointer = findP(pointer, nums);
		}

		return prims.size();

	}

	public int findP(int pointer, int[] nums) {
		if (pointer > nums.length)
			return 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > pointer)
				return nums[i];
		}
		return 0;
	}

	
	public int countPrimesA(int n) {
		if (n <= 2)
			return 0;
		
		int [] prim = new int[n];
		Arrays.fill(prim,0);
		
		for(int i =2; i< n; i++)
		{
			if (prim[i] == 1)
				continue;
			for(int j =2*i; j< n; j+=i)
			{
				prim[j] = 1;
			}
		}
		
		int count = 0;
		
		for(int i= 2; i< n; i++)
		{
			if(prim[i] == 0)
				count++;
		}
		
		return count;
	}
	
	public int countPrimesB(int n) {
		if (n <= 2)
			return 0;
		
		int [] prim = new int[n];
		Arrays.fill(prim,0);
		
		for(int i =2; i<= Math.sqrt(n-1); i++)
		{
			if (prim[i] == 1)
				continue;
			for(int j =i*i; j< n; j+=i)
			{
				prim[j] = 1;
			}
		}
		
		int count = 0;
		
		for(int i= 2; i< n; i++)
		{
			if(prim[i] == 0)
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		System.out.println(s.countPrimes(499979));
	}

}
