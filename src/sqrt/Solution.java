package sqrt;

public class Solution {
	public int mySqrt(int x) {
		int p = 1;
		int q = x/2+1;

		while (p <= q) {
			
			int mid = (p+q)/2;
			if (mid <= x/mid && (mid + 1) > x/(mid+1))
				return mid;
			if (mid < x/mid)
				p = mid + 1;
			else
				q = mid - 1;
			
			
		}

		return 0;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		int a = s.mySqrt(2147483647);
		System.out.println(a);
	
		
	}
}
