package wordDictionary;

import java.util.*;

public class TrieNode {

	char content;
	List<TrieNode> childList;
	boolean isEnd;
	int count;

	public TrieNode(char ch) {
		content = ch;
		childList = new ArrayList<TrieNode>();
		isEnd = false;
		count = 0;
	}

	public TrieNode subNode(char ch) {
		if (childList != null) {
			for (TrieNode eachNode : childList) {
				if (eachNode.content == ch)
					return eachNode;

			}
		}

		return null;
	}
}
