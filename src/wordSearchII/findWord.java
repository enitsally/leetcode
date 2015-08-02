package wordSearchII;

import java.util.*;

import wordDictionary.TrieNode;

public class findWord {

	TrieNode root = new TrieNode(' ');

	public List<String> findWords(char[][] board, String[] words) {

		if (board == null || board.length == 0 || board[0].length == 0
				|| words.length == 0 || words == null)
			return null;

		List<String> result = new ArrayList<String>();
		int wordsLen = words.length;

		int[] visited = new int[wordsLen];

		return result;

	}

	public void buildTrie( char[][] board, int pi, int pj, TrieNode beginRoot) {
		
		TrieNode current = beginRoot;
		
		
	
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j< board[0].length; j++)
			{
				
				
				TrieNode temp = current.subNode(board[i][j]);
				
				
				TrieNode node = new TrieNode(board[i][j]);
			}
		}
		

	}
}
