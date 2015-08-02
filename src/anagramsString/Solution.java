package anagramsString;

import java.util.*;

public class Solution {

	public class AnagramComparator implements Comparator<String>{
		public String sortChars(String s){
			char[] content = s.toCharArray();
			Arrays.sort(content);
			
			return new String(content);
		}
		
		public int compare(String s1, String s2){
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
	
	public static void main (String[] args){	
		Solution s = new Solution();
		String[] str = new String[]{"abcd", "aaaa","dabc", "nnnn", "acdb"};
		
		Arrays.sort(str, s.new AnagramComparator());
		
		for(String tmp : str)
			System.out.println(tmp);
		
	}
	
	public class myComparator implements Comparator<String>{
		public String sortChars(String s){
			char[] context = s.toCharArray();
			Arrays.sort(context);
			return new String(context);
		}
		
		public int compare(String s1, String s2){
			return sortChars(s1).compareTo(sortChars(s1));
		}
	}
}
