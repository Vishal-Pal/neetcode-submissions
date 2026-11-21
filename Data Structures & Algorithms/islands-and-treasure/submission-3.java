class Solution {
    private int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]!=0){
                    continue;
                }
                q.offer(new int[]{row, col});
            }
        }
        while(!q.isEmpty()){
            int[] rowCol = q.poll();
            int row = rowCol[0], col = rowCol[1];
            for(int[] direction:directions){
                int nextRow = row+direction[0], nextCol = col+direction[1];
                if(nextRow<0||nextRow>=rows
                ||nextCol<0||nextCol>=cols
                ||grid[nextRow][nextCol]!=Integer.MAX_VALUE){
                    continue;
                }
                grid[nextRow][nextCol]=1+grid[row][col];
                q.offer(new int[]{nextRow, nextCol});
            }
        }
    }
}


/***



Input: [
  [2147483647,-1        ,0         ,2147483647],
  [2147483647,2147483647,2147483647,-1        ],
  [2147483647,-1        ,2147483647,-1        ],
  [0         ,-1        ,2147483647,2147483647]
]

row = 0, col = 0
visited = [
  [true,false,false,false],
  [true ,true ,true ,false],
  [false,false,false,false],
  [false,false,false,false]
]


Output: [
  [3,-1, 0, 1],
  [2, 2, 1,-1],
  [1,-1, 2,-1],
  [0,-1, 3, 4]
]


=> Start traversal from a treasure chest
=> Update the adjacent land cell's value if it is greater than the current distance

=> Start traversal from a treasure chest
=> DFS
- Current cell is Treasure
 => Traverse its neighbors
- Current cell is Water
 => I cannot proceeed in that direction, so I need to return from here
- Current cell is Land
 => Update its value if it is greater than the current distance
 => Traverse its neighbors


*/