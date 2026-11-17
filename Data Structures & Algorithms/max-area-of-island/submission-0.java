class Solution {
    private static final int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(visited[row][col] || grid[row][col] == 0){
                    continue;
                }
                maxArea = Math.max(maxArea, dfs(grid, row, col, visited));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited){
        int rows = grid.length, cols = grid[0].length;
        visited[row][col] = true;
        int currArea = 1;
        for(int[] direction:directions){
            int nextRow = row+direction[0];
            int nextCol = col+direction[1];
            if(nextRow<0||nextRow>=rows
        ||nextCol<0||nextCol>=cols
        ||visited[nextRow][nextCol]
        || grid[nextRow][nextCol] == 0){
                continue;
            }
            currArea+=dfs(grid, nextRow, nextCol, visited);
        }
        return currArea;
    }
}

/***

In general -> DFS -> We do not return any value
For the number of islands

We can track the area per DFS call
For each depth, we can have the current depth

int area(int[][] grid, curr Area, int r, int c)

For each dfs call -> return the number of visited cells
For visited cells/ invalid cells - out of bound/ water -> 0
count

1-0
1


*/
