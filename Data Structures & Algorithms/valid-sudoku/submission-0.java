class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length=9;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer>[] colSets = new Set[length];
        Set<Integer>[] gridSets = new Set[length];
        for(int ind=0;ind<length;ind++){
            colSets[ind] = new HashSet<>();
            gridSets[ind] = new HashSet<>();
        }
        for(int row=0;row<length;row++){
            for(int col=0;col<length;col++){
                char ch = board[row][col];
                if(ch=='.'){
                    continue;
                }
                int num = (int)ch;
                Set<Integer> colSet = colSets[col];
                int grid = getGrid(row, col);
                Set<Integer> gridSet = gridSets[grid];
                if(rowSet.contains(num)
                || colSet.contains(num)
                || gridSet.contains(num)){
                    return false;
                }
                rowSet.add(num);
                colSet.add(num);
                gridSet.add(num);
            }
            rowSet.clear();
        }
        return true;
    }

    private int getGrid(int row, int col){
        if(row>=0 && row<=2){
            if(col>=0 && col<=2){
                return 0;
            } else if(col>=3 && col<=5){
                return 1;
            } else{
                return 2;
            }
        } else if(row>=3 && row<=5){
            if(col>=0 && col<=2){
                return 3;
            } else if(col>=3 && col<=5){
                return 4;
            } else{
                return 5;
            }
        } else if(col>=0 && col<=2){
            return 6;
        } else if(col>=3 && col<=5){
            return 7;
        } else{
            return 8;
        }
    }
}
