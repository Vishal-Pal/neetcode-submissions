class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = 9;
        int[] rows = new int[length];
        int[] cols = new int[length];
        int[] grids = new int[length];
        for (int rowNo = 0; rowNo < length; rowNo++) {
            for (int colNo = 0; colNo < length; colNo++) {
                char ch = board[rowNo][colNo];
                if (ch == '.') {
                    continue;
                }
                int num = ch - '1';

                int gridNo = getGridNo(rowNo, colNo);

                // Calculate Position to Check
                int pos = 1 << num;

                // Check whether bit at position is set
                if (isBitSet(rows[rowNo], pos) || isBitSet(cols[colNo], pos)
                    || isBitSet(grids[gridNo], pos)) {
                    return false;
                }

                // Set the bit at position
                rows[rowNo] |= pos;
                cols[colNo] |= pos;
                grids[gridNo] |= pos;
            }
        }
        return true;
    }

    private boolean isBitSet(int val, int pos) {
        return (val & pos) > 0;
    }

    private int getGridNo(int rowNo, int colNo) {
        return ((rowNo / 3) * 3 + (colNo / 3));
    }
}