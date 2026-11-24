class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int freshCount = 0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==2){ // Offer rotten oranges to queue
                    q.offer(new int[]{row, col});
                } else if(grid[row][col]==1){
                    freshCount++;
                }
            }
        }
        if(q.isEmpty()){
            return freshCount == 0 ? 0:-1;
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int time = 0;
        while(!q.isEmpty() && freshCount != 0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] rowCol = q.poll();
                int row = rowCol[0];
                int col = rowCol[1];
                for(int[] direction:directions){
                    int nextRow = row+direction[0];
                    int nextCol = col+direction[1];
                    // If indices out of bound
                    // or its not a fresh fruit
                    if(nextRow<0||nextRow>=rows
                    ||nextCol<0||nextCol>=cols
                    ||grid[nextRow][nextCol]!=1){
                        continue;
                    }
                    // Make it rotten and decrease fresh count as well
                    freshCount--;
                    grid[nextRow][nextCol]=2;
                    // Add it to queue
                    q.offer(new int[]{nextRow, nextCol});
                }
            }
            time++;
        }
        return freshCount == 0 ? time:-1;
    }
}

/***

We can traverse from rotten oranges to the fresh oranges
We cannot traverse empty cells

We need to find the minimum time to rot all oranges
1 unit time = A rotten orange rotting each of its adjacent fresh oranges
We need to rot/ traverse from the rotten oranges to the fresh oranges in a single unit of time

Add all rotten oranges to Q
Then iterate over the queue level by level
Why level by level?
1 level will be processed in one unit of time
When level is processed, I will increment time by 1
At the end, I'd iterate the entire grid to confirm that the there are no fresh fruits in any cell

*/