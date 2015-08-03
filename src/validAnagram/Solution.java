package validAnagram;

import java.util.*;

public class Solution {
	public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char ch : s_chars){
        	if (map.containsKey(ch))
        		map.put(ch, map.get(ch)+1);
        	else
        		map.put(ch, 1);
        }
        
        for(char ch : t_chars){
        	if (map.containsKey(ch))
        		map.put(ch, map.get(ch)-1);
        }
        
        Iterator<Map.Entry<Character,Integer>> it = map.entrySet().iterator();
        
        while(it.hasNext()){
        	Map.Entry<Character, Integer> ele = it.next();
        	if (ele.getValue() != 0)
        		return false;
        }
       
        return true;
    }
	
	public static void main(String[] args){
		Solution solution = new Solution();
		
		String s = "a";
		String t = "a";
		
		System.out.println(solution.isAnagram(s, t));
	}
}
