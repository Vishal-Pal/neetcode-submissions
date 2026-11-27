class Solution {
    private int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        Boolean[][][] dp = new Boolean[rows][cols][2];
        boolean[][] visited = new boolean[rows][cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(dfs(heights,row,col, false, dp, visited) && dfs(heights,row,col, true, dp, visited)){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(row);
                    curr.add(col);
                    res.add(curr);
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] heights, int row, int col, boolean isAtlantic, Boolean[][][] dp, boolean[][] visited){
        int atlanticIndex = isAtlantic ? 1:0;
        if(dp[row][col][atlanticIndex]!=null){
            return dp[row][col][atlanticIndex];
        }
        visited[row][col] = true;
        int rows = heights.length, cols = heights[0].length;
        for(int[] direction:directions){
            int nextRow = row+direction[0];
            int nextCol = col+direction[1];
            if(isAtlantic){
                if(nextRow == rows || nextCol == cols){
                    visited[row][col] = false;
                    return dp[row][col][atlanticIndex] = true;
                }
            } else if(nextRow == -1 || nextCol == -1){
                visited[row][col] = false;
                return dp[row][col][atlanticIndex]=true;
            }
            if(nextRow<0||nextRow==rows || nextCol<0 || nextCol==cols || visited[nextRow][nextCol]){
                continue;
            }
            if(heights[nextRow][nextCol]<=heights[row][col] && dfs(heights, nextRow, nextCol, isAtlantic, dp, visited)){
                visited[row][col] = false;
                return dp[row][col][atlanticIndex]=true;
            }
        }
        visited[row][col] = false;
        return dp[row][col][atlanticIndex]=false;
    }
}

/***


Water flows from height equal to lower
Water can flow from ocean to cell and cell to ocean

What I need to find is whether water can flow from this cell
to both Pacific and Atlantic oceans

How will water flow, i.e., what cells can satisfy this condition?


Input: heights = [
              Pacific
            [4,2,7,3,4],
  Pacific   [7,4,6,4,7],  Atlantic
            [6,3,5,3,6]
              Atlantic
]

r=0, c=0
nR = -1, nC = 0


(r,c) -> I should be able to travel either completely in either of the rows side and also either of the cols side

r->0 Pacific, r->len-1 Atlantic  c->len-1 Atlantic


r-1, c r+1, c r,c-1, r, c+1
Left, Right, Up, Down

Pacific -> Left/Up
Atlantic -> Right/Down

Pacific Traversal
=> Left/ Up
Pick one direction
Check if I can travel in that direction
Check if I reach the end in that direction
If I do, then yes I can traverse to Pacific from there



[
[1,2,3],
[8,9,4],
[7,6,5]
]



*/