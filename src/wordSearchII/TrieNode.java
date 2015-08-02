package wordSearchII;

import java.util.*;

public class TrieNode {
	
	char content;
	List<TrieNode> childList;
	List<TrieNode> parentList;
	boolean isEnd;
	int count;
	
	
	public TrieNode(char c){
		content = c;
		childList = new ArrayList<TrieNode>();
		parentList = new ArrayList<TrieNode>();
		count = 0;
		isEnd = false;
	}
	
	public TrieNode subNode(char c)
	{
		if (childList != null)
		{
			for(TrieNode eachNode: childList)		
			{
				if (eachNode.content == c)
					return eachNode;
			}
		}
		return null;
	}
	
	public TrieNode parenetNode(char c)
	{
		if(parentList != null)
		{
			for(TrieNode parent : parentList)
			{
				if(parent.content == c)
				{
					return parent;
				}
			}
		}
		return null;
	}


}
