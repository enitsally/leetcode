package uniquePath;

public class Solution {
	public int uniquePaths(int m, int n) {

		if (m == 0 || n == 0)
			return 0;

		int[][] visit = new int[m][n];

		for (int i = 0; i < m; i++)
			visit[i][0] = 1;

		for (int j = 0; j < n; j++)
			visit[0][j] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				visit[i][j] = visit[i - 1][j] + visit[i][j - 1];
			}
		}

		return visit[m - 1][n - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] visit = new int[m][n];
		
		if (obstacleGrid[0][0] == 1)
		    return 0;
		else
		    visit[0][0] =1;
		
		for(int i = 1; i< m; i++){
			if (obstacleGrid[i][0] == 1)
				visit[i][0] = 0;
			else
				visit[i][0] = visit[i-1][0];
		}
		
		for(int j = 1; j < n; j++){
			if (obstacleGrid[0][j] == 1)
				visit[0][j]= 0;
			else
				visit[0][j] = visit[0][j-1];
		}
		
		for( int i = 1; i < m; i++){
			for(int j = 1; j< n; j++){
				
				if( obstacleGrid[i][j] == 1)
					visit[i][j] = 0;
				
				else
					visit[i][j] = visit[i-1][j] + visit[i][j-1];
			}
		}
		
		return visit[m-1][n-1];
			
	}
}
