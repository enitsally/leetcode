package trieNode;

import java.util.*;

//import ExePackage.TrieNode;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode(' ');
	}

	public void insert(String word) {
		// word in already exist in the tree
		if (search(word) == true)
			return;

		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = current.subNode(ch);
			if (child != null)
				current = child;
			else {
				current.childList.add(new TrieNode(ch));
				current = current.subNode(ch);
			}
			current.count++;
		}
		current.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (current.subNode(ch) == null)
				return false;
			else
				current = current.subNode(ch);
		}
		if (current.isEnd == true)
			return true;
		return false;
	}

	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (char ch : prefix.toCharArray()) {
			if (current.subNode(ch) == null)
				return false;
			else
				current = current.subNode(ch);
		}

		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int func ;
		Trie trie = new Trie();
		
		while (true)
		{
			System.out.println("Choose from menu: 1 for Add, 2 for Search, 3 for Prefix, 0 for exit");
			Scanner s = new Scanner(System.in);
			func = s.nextInt();
			
			if (func == 0)
			{
				System.out.println("Quit");
				System.exit(0);
			}
			else if (func == 1)
			{
				System.out.println("Enter the word to insert:");
				s = new Scanner(System.in);
				String word = s.nextLine();
				trie.insert(word);
			}
			else if (func == 2)
			{
				System.out.println("Enter the word to search:");
				s = new Scanner(System.in);
				String word = s.nextLine();
				System.out.println(trie.search(word));
			}
			else if (func == 3)
			{
				System.out.println("Enter the word for prefix:");
				s = new Scanner(System.in);
				String word = s.nextLine();
				System.out.println(trie.startsWith(word));
			}
			else{
				System.out.println("Unrecoginzed enter, please try again");
			}
		}
		
	}
}
