package numberOfIslands;

public class Solution {
	public int numIslands(char[][] grid) {
		
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		
		int count = 0;
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j] == '1')
				{
					count++;
					mergeIslands(grid,i,j);
				}
			}
		}
		
		return count;
	}
	
	public void mergeIslands(char[][] grid, int i, int j)
	{
		if (i< 0 || j< 0 || i> grid.length -1 || j> grid[0].length -1)
			return;
		
		if (grid[i][j] != '1') //have been visited or it is water instead of island
			return;
		
		grid[i][j] = '2'; //have been visited
		mergeIslands(grid, i+1, j);
		mergeIslands(grid, i-1, j);
		mergeIslands(grid, i, j+1);
		mergeIslands(grid, i, j-1);
	}

}
