class Solution {
    public int largestIsland(int[][] grid) {
        
        // improve by adding a memo 
        int[][] memo = new int[grid.length][grid[0].length];
        
        // run dfs once for every 1 seen in the graph 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // not going to implement here but the idea is 
                // run dfs on every 1 in the graph and store the size 
                // of existing connected components 
            }
        }
        int max = 0;
        boolean noZero = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    noZero = false;
                    int[][] clone = Arrays.stream(grid)
                                          .map(el -> el.clone())
                                          .toArray($ -> grid.clone());
                    clone[i][j] = 1; 
                    int count = dfs(clone, j, i);
                    if (count > max) max = count;
                }
            }
        }
        if (noZero) return grid.length * grid[0].length;
        return max;
    }
    
    public int dfs(int[][] grid, int x, int y) {
        if (!(isInbound(grid, x, y))) return 0;
        if (grid[y][x] == 0) return 0;
        grid[y][x] = 0;
        return dfs(grid, x+1, y) + dfs(grid, x-1, y) + dfs(grid, x, y+1) + dfs(grid, x, y-1) + 1;
    }
    
    public boolean isInbound(int[][] grid, int x, int y) {
        return x < grid[0].length && x >= 0 && y < grid.length && y >= 0;
    }

}

/*
827. Making A Large Island
Hard

You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
*/