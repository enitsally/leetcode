package strstr;

public class Solution {

	public int strStr(String haystack, String needle) {
		if (haystack == null || haystack.length() == 0 || needle == null
				|| needle.length() == 0)
			throw new IllegalArgumentException("Illegal argument input");

		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length()) 
					return i;
				if (i + j == haystack.length()) 
					return -1;
				if (needle.charAt(i) != haystack.charAt(i+j))
					break;
			}

		}
	}
}
