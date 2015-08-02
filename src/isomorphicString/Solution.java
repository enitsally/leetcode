package isomorphicString;

import java.util.Hashtable;

public class Solution {

	public boolean isIsomorphic(String s, String t) {
		
		if (s == null || t == null || s.length() != t.length())
			return false;

		
		Hashtable<String,String> dic = new Hashtable<String,String>();
		
		for(int i = 0 ; i< s.length(); i++)
		{
			String value = String.valueOf(t.charAt(i));
			String key = String.valueOf(s.charAt(i));
			
			if (!dic.containsKey(key))
			{
				if(dic.containsValue(value)){
			        return false;
			    }
				dic.put(key, value);
			}
			else
			{
				if (dic.get(key).equals(value) && dic.containsValue(value))
					continue;
				else
					return false;
			}
		}
		return true;
		
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution s = new Solution();
		System.out.println(s.isIsomorphic("ab", "aa"));
	}

}
