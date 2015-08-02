package regularExpressionMatching;

public class Solution {
	public boolean isMatch(String s, String p) {
		
		if (p.length() == 0)
			return s.length() == 0;
		
		//base case with pattern has only one character.	
		if (p.length() == 1){
			if (s.length() == 0)
				return false;
			
			else if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
				return false;
			else 
				return isMatch(s.substring(1), "");
		}
		
		//case 1: the second place of pattern is not "*"		
		if (p.charAt(1) != '*'){
			if (s.length() == 0)
				return false;
			
			if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
				return false;
			else
				return isMatch(s.substring(1), p.substring(1));
			
		}
		//case 2: the second place of pattern is "*"
		else{
			
			//case 2.1 s match the rest of the pattern, assuming the first * is 0;
			if (isMatch(s, p.substring(2)))
				return true;
			
			int i = 0, n = s.length();
			
			while (i< n && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
				if (isMatch(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
			
	}
	
	public static void main(String[] args) {
		String tmp = ".*c";
		Solution s = new Solution();
		System.out.println(s.isMatch("ab", tmp));
	}
}
