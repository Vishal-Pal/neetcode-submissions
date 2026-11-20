class Solution {
    private static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        char[] wordArr = word.toCharArray();
        boolean[][] visited = new boolean[rows][cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(exist(board, wordArr, row, col, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] wordArr, int row, int col, int ind, boolean[][] visited){
        int len = wordArr.length;
        if(ind>=len){
            return true;
        }
        int rows = board.length, cols = board[0].length;
        if(row<0||row>=rows
        ||col<0||col>=cols
        ||visited[row][col]
        ||board[row][col]!=wordArr[ind]){
            return false;
        }
        visited[row][col] = true;
        for(int[] direction:directions){
            int nextRow = row+direction[0], nextCol = col+direction[1];
            if(exist(board, wordArr, nextRow, nextCol, ind+1, visited)){
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}


/****

ABCESEEEFS

[["A","B","C","E"]
,["S","F","E","S"]
,["A","D","E","E"]]



*/