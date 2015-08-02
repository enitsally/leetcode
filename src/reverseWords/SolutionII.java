package reverseWords;

public class SolutionII {

	public void reverseWords(char[] s)
	{
		reverse(s,0,s.length);
		for(int i = 0, j = 0; j<= s.length; j++){
			
			if (j == s.length || s[j] == ' ')
			{
				reverse(s, i, j);
				i = j+1;
			}
		}
		
	}
	
	public void reverse(char[] s, int begin, int end)
	{
//		for(int i = 0; i < (end-begin)/2; i++)
//		{
//			char tmp = s[begin + i];
//			s[begin + i] = s[end-i-1];
//			s[end-i-1] = tmp;
//			
//		}
		
		while (begin< end)
		{
			char tmp = s[end-1];
			s[end-1] = s[begin];
			s[begin] = tmp;
			begin++;
			end--;
		}
	}
	
	public static void main (String[] args)
	{
		SolutionII solution = new SolutionII();
		
		char[] s = new String("the sky is blue").toCharArray();
		
		solution.reverseWords(s);
		System.out.println(String.copyValueOf(s));
	}
}
