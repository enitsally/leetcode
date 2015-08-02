package rangeBitwiseAnd;

public class Solution {
	public int rangeBitwiseAnd(int m, int n)
	{
		while ( n > m)
		{
			n = n & (n-1);
		}
		return m & n;
	}
	
	public static void main (String[] args)
	{
		System.out.println( 0&5 ) ;
		
		Solution s = new Solution();
		System.out.println( s.rangeBitwiseAnd(5,8) ) ;
	}
}
