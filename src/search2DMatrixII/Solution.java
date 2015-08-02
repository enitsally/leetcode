package search2DMatrixII;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;

		int i = 0;
		int j = n-1;

		while (i < m && j >=0 ) {
			if (target == matrix[i][j])
				return true;
			else if (target > matrix[i][j])
				i++;
			else if (target < matrix[i][j])
				j--;
		}

		return false;
	}
	
	public static void main (String[] args){
		Solution s = new Solution();
		
		int[][] matrix = new int[][]{{-5}};
		
		System.out.println(s.searchMatrix(matrix, -2));
	}

}
