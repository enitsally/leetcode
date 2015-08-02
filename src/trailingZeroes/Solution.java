package trailingZeroes;

public class Solution {
	public int trailingZeroesA(int n) {

		if (n < 0)
			return -1;
		if (n == 0)
			return 1;
		if (n == 1 || n ==2 || n==3 || n == 4)
			return 0;
		
		if (n == 5)
			return 1;
			

		int count = 0;
		String temp = String.valueOf(n);
		for (int i = temp.length() - 1; i >= 0; i--) {
			if (temp.charAt(i) != '0')
				break;
			count++;
		}

		return count+trailingZeroes(n - 1);

	}
	
	public int trailingZeroes(int n) {

		if(n < 0)
			return -1;
		
		int count = 0;
		
		for(long i = 5; n/i>=1; i*=5)
		{
			count += n/i;
		}
		
		return count;
	}
	
	public static void main (String[] args)
	{
		Solution s = new Solution();
		
		System.out.println(s.trailingZeroes(1808548329));
	}
}
