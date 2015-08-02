package longestPalindromicSubstring;

public class Solution {
	 public String longestPalindromeDP(String s){
		 int length = s.length();
		 boolean[][] map = new boolean[length][length];
		 
		 int longestBegin = 0;
		 int maxLen = 1;
		 
		 for(int i = 0; i< length; i++)
		 {
			 map[i][i] = true;
		 }
		 
		 for(int i = 0; i < length-1 ; i++){
			 if (s.charAt(i) == s.charAt(i+1)){
				 map[i][i+1] = true;
				 longestBegin = i;
				 maxLen = 2;
			 }
				 
		 }
		 
		 for(int len = 3; len <=length; len ++){
			 for(int i = 0; i < length -len+1; i++){
				 int j = i + len -1;
				 if (s.charAt(i) == s.charAt(j) && map[i+1][j-1]){
					 map[i][j] = true;
					 longestBegin = i;
					 maxLen = len;
				 }
			 }
		 }
			 
		 return s.substring(longestBegin, maxLen);
		 
		 
	 }
	 
	 public String longestPalindrome(String s){
		 if ( s == null)
			 return null;
		 if(s.length() == 1)
			 return s;
		 String longest = s.substring(0, 1);
		 
		 for(int i = 0; i< s.length(); i++){
			 String tmp = helper(s, i, i);
			 if(tmp.length()> longest.length())
				 longest = tmp;
			 
			 tmp = helper(s, i, i+1);
			 if(tmp.length() > longest.length())
				 longest = tmp;
		 }
		 
		 return longest;
	 }
	 
	 public String helper(String s, int begin, int end){
		 while (begin>= 0 && end<=s.length()-1 && s.charAt(begin) == s.charAt(end)){
			 begin--;
			 end++;
		 }
		 
		 return s.substring(begin+1, end);
	 }
	 
	 public static void main(String[] args){
		 Solution s = new Solution();
		 
		 System.out.println(s.longestPalindromeDP("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	 }
}
