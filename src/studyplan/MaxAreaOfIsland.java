//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) 
//connected 4-directionally (horizontal or vertical.) 
//You may assume all four edges of the grid are surrounded by water.
//
//The area of an island is the number of cells with a value 1 in the island.
//
//Return the maximum area of an island in grid. If there is no island, return 0.
//
//Constraints:
//	m == grid.length
//	n == grid[i].length
//	1 <= m, n <= 50
//	grid[i][j] is either 0 or 1.

package studyplan;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = 
			   {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		int ans = new MaxAreaOfIsland().maxAreaOfIsland(grid);
		System.out.println(ans);
	}
	
	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (visited[i][j] == false) {
					if (grid[i][j] == 1) {
						max = Math.max(max, computeArea(i,j,grid,visited));
					}
				}else {
					visited[i][j] = true;
				}
				
			}
		}
		return max;
	}

	private int computeArea(int i, int j, int[][] grid, boolean[][] visited) {
		if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && visited[i][j] == false) {
			visited[i][j] = true;
			if (grid[i][j] == 1) {
				return 1 + computeArea(i+1, j, grid, visited) + computeArea(i-1, j, grid, visited) 
				         + computeArea(i, j+1, grid, visited) + computeArea(i, j-1, grid, visited);
			}
		}
		return 0;
	}

}
