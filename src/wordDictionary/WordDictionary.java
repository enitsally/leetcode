package wordDictionary;

import java.util.*;

public class WordDictionary {

	TrieNode root = new TrieNode(' ');

	public WordDictionary() {

	}

	// Add a word into the data structure
	public void addWord(String word) {

		if (search(word, root) == true)
			return;

		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = current.subNode(ch);
			if (child != null) {
				current = child;
			} else {
				TrieNode newChild = new TrieNode(ch);
				current.childList.add(newChild);
				current = current.subNode(ch);
			}
			current.count++;
		}
		current.isEnd = true;
		
	}
	
	public boolean search(String word){
        return search(word, root);
    }

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter
	public boolean search(String pattern, TrieNode beginRoot) {
		TrieNode current = beginRoot;
		
		for(int index = 0; index < pattern.length(); index ++)
		{
			char ch = pattern.toCharArray()[index];
			if (current.subNode(ch) != null )
			{
				current = current.subNode(ch);
			}
			else if (ch == '.')
			{
				
				boolean result = false;
				String newPattern = pattern.substring(index+1);
				
				if (current.childList != null)
				{
					List<TrieNode> chidren = current.childList;
					for (TrieNode child : chidren)
					{
						result = result || search(newPattern,child);
					}
						
					return result;
				}
				return false;
				
			}
			else
			{
				return false;
			}
		}
		if (current.isEnd == true)
			return true;
		return false;
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word")
	// wordDictionary.search("pattern")

	public static void main(String[] args) {
		String str_input;
		String str_func;
		
		WordDictionary wd = new WordDictionary();

		while (true) {
			System.out
					.println("Do you want to Add (1) a new word or Search (2) a pattern? '0' to exit.");
			Scanner s = new Scanner(System.in);

			str_func = s.nextLine();

			if (str_func.equalsIgnoreCase("0")) {
				System.out.println("Quit!!");
				System.exit(0);
			} else if (str_func.equalsIgnoreCase("1")) {

				System.out.println("Enter the word:");
				s = new Scanner(System.in);
				str_input = s.nextLine();
				wd.addWord(str_input);

			} else if (str_func.equalsIgnoreCase("2")) {
				System.out.println("Enter the pattern:");
				s = new Scanner(System.in);
				str_input = s.nextLine();

				System.out.println(wd.search(str_input));
			} else {
				System.out.println("Unrecoginzed input, please try again.");
			}
		}

	}
}
