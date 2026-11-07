class Solution {
    int rowCount,colCount;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        Set<String> res = new HashSet<>();
        for(String word:words){
            root.addWord(word);
        }
        int rowCount = board.length, colCount = board[0].length;
        for(int row=0;row<rowCount;row++){
            for(int col=0;col<colCount;col++){
                dfs(board, row,col,root,new boolean[rowCount][colCount], "", res);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int row, int col, TrieNode node, boolean[][] visited, String word, Set<String> res){
        int rowCount = board.length, colCount = board[0].length;
        if(row<0||row>=rowCount
        ||col<0||col>=colCount
        ||visited[row][col]
        ||!node.hasNeighbor(board[row][col])){
            return;
        }
        visited[row][col] = true;
        char ch = board[row][col];
        node = node.getNeighbor(ch);
        word+=ch;
        if(node.isEndOfWord()){
            res.add(word);
        }
        dfs(board, row-1, col, node, visited, word, res);
        dfs(board, row+1, col, node, visited, word, res);
        dfs(board, row, col-1, node, visited, word, res);
        dfs(board, row, col+1, node, visited, word, res);
        visited[row][col] = false;
    }

    public class TrieNode{
        TrieNode[] neighbors;
        boolean isEndOfWord;
        public TrieNode(){
            neighbors = new TrieNode[26];
        }
        public boolean hasNeighbor(char ch){
            return neighbors[getIndex(ch)]!=null;
        }
        public TrieNode getNeighbor(char ch){
            return neighbors[getIndex(ch)];
        }
        public void addWord(String word){
            TrieNode node = this;
            for(char ch:word.toCharArray()){
                if(node.neighbors[getIndex(ch)]==null){
                    node.neighbors[getIndex(ch)] = new TrieNode();
                }
                node =  node.neighbors[getIndex(ch)];
            }
            node.isEndOfWord = true;
        }
        public boolean isEndOfWord(){
            return isEndOfWord;
        }
        private int getIndex(char ch){
            return ch-'a';
        }
    }
}


/***


Work is to think how to populate the neighbors of each cell in the board

1) Populate Neighbors
2) To ensure that a character is not revisited - Visited Set

i, j -> i-1, j; i+1, j; i,j-1; i,j+1

Map<Index, TrieNode>

Populate Neighbors

Step 1 - Create a map of Index->TrieNode. Why? Because this map shall help me in creating the neighbors
w/o creating extra nodes

Step 2 - Iterate over the board and to populate the neighbors fetching neighbors from the above map

For index - int[]
i,j
Flatten the array -
0 1 2 3
4
0+4*1, 1+4*1
4*2+0 = 8
ind = n*i+j


Any character can be the start

Previously from the trie root

Each trie root has only specific neighbors




*/