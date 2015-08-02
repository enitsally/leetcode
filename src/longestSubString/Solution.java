package longestSubString;

import java.util.Arrays;

public class Solution {
	public int lengthOfLongestSubstring(String s){
		
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		
		int i = 0, maxLen = 0;
		
		for(int j = 0; j< s.length(); j++){
			char tmp = s.charAt(j);
			int t = Character.getNumericValue(tmp);
			if (charMap[t] >= i){
				i = charMap[t] + 1;
			}
			charMap[t] = j;
			maxLen = Math.max(maxLen, j-i+1);
		}
		
		return maxLen;
	}
	
	// Longest substring with at most K distinct characters.
	
	public int lengthOfLongestSubstringKDistinct (String s, int k){
		
		int[] count = new int[256];
		int start = 0, numDistinct = 0, maxLen = 0; 
		
		for(int j = 0; j< s.length(); j++){
			if (count[s.charAt(j)] == 0) 
				numDistinct++;		
			count[s.charAt(j)] ++;
			
			while (numDistinct > k){
				count[s.charAt(start)] --;
				if (count[s.charAt(start)] == 0) 
					numDistinct ++;
				start ++;
			}
			maxLen = Math.max(maxLen, j - start +1);
		}
		
		return maxLen;
	}
	
	
	public static void main (String[] args){
		Solution s  = new Solution();
		
		System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
	}

}
