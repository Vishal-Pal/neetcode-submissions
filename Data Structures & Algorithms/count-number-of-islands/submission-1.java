class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]=='0' || visited[row][col]){
                    continue;
                }
                islands++;
                dfs(grid, row, col, visited);
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;
        if(row<0 || row>=rows
        || col<0 || col>=cols
        || visited[row][col]
        || grid[row][col]=='0'){
            return;
        }
        visited[row][col]=true;
        dfs(grid, row-1, col, visited);
        dfs(grid, row+1, col, visited);
        dfs(grid, row, col-1, visited);
        dfs(grid, row, col+1, visited);
    }
}

/***

Visit all the neighbors of a cell at once

*/
