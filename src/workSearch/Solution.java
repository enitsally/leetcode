package workSearch;

public class Solution {
	public boolean exist(char[][] board, String word) {
		
		int n = board.length;
		int m = board[0].length;
		
		boolean[][] visit = new boolean[n][m];
		
		for(int i = 0; i< n ; i++){
			for(int j = 0; j< m; j++){
				if (search(board, word, 0, i, j, visit) == true)
					return true;
			}
		}
		
		return false;

	}
	
	public boolean search(char[][] board, String word, int index, int rowIndex, int colIndex, boolean[][] visit){
		if (index == word.length())
			return true;
		if ( rowIndex >= board.length || colIndex >= board[0].length || rowIndex < 0 || colIndex < 0)
			return false;
		if (visit[rowIndex][colIndex] == true)
			return false;
		if(board[rowIndex][colIndex] != word.charAt(index))
			return false;
		
		visit[rowIndex][colIndex] = true;
		
		boolean r = search(board, word, index +1, rowIndex-1, colIndex, visit) ||
				search(board, word, index +1, rowIndex+1, colIndex, visit) ||
				search(board, word, index +1, rowIndex, colIndex-1, visit) ||
				search(board, word, index +1, rowIndex, colIndex+1, visit);
		
		visit[rowIndex][colIndex] = false;
		
		return r;
	}
}
