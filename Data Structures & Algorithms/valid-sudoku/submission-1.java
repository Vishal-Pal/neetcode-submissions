class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = 9;
        boolean[][] seenInRows = new boolean[length][length];
        boolean[][] seenInCols = new boolean[length][length];
        boolean[][] seenInGrids = new boolean[length][length];
        for (int row = 0; row < length; row++) {
            boolean[] seenInRow = seenInRows[row];
            for (int col = 0; col < length; col++) {
                char ch = board[row][col];
                if (ch == '.') {
                    continue;
                }
                int num = ch - '1';
                boolean[] seenInCol = seenInCols[col];
                int grid = getGrid(row, col);
                boolean[] seenInGrid = seenInGrids[grid];
                if (seenInRow[num] || seenInCol[num] || seenInGrid[num]) {
                    return false;
                }
                seenInRow[num] = true;
                seenInCol[num] = true;
                seenInGrid[num] = true;
            }
        }
        return true;
    }

    private int getGrid(int row, int col) {
        return ((row / 3) * 3 + (col / 3));
    }
}