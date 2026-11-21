class Solution {
    private int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]!=0){
                    continue;
                }
                q.offer(new int[]{row, col});
            }
        }
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] rowCol = q.poll();
                int row = rowCol[0], col = rowCol[1];
                if(row<0||row>=rows
                ||col<0||col>=cols
                ||visited[row][col]
                ||grid[row][col]==-1){
                    continue;
                }
                visited[row][col] = true;
                grid[row][col]=level;
                for(int[] direction:directions){
                    q.offer(new int[]{row+direction[0],col+direction[1]});
                }
            }
            level++;
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