class PrefixTree {
    final PrefixTreeNode root;
    final char wordEndDelimiter;
    public PrefixTree() {
        root = new PrefixTreeNode('*');
        wordEndDelimiter = '#';
    }

    public void insert(String word) {
        PrefixTreeNode node = root;
        for(char ch:word.toCharArray()){
            PrefixTreeNode chNode = node.getNeighbor(ch);
            if(chNode == null){
                chNode = new PrefixTreeNode(ch);
                node.addNeighbor(chNode);
            }
            node = chNode;
        }
        node.addNeighbor(new PrefixTreeNode(wordEndDelimiter));
    }

    public boolean search(String word) {
        PrefixTreeNode node = getLastPrefixNode(word);
        if(node == null){
            return false;
        }
        PrefixTreeNode endOfWordNode = node.getNeighbor(wordEndDelimiter);
        return endOfWordNode != null;
    }

    public boolean startsWith(String prefix) {
        return getLastPrefixNode(prefix) != null;
    }

    private PrefixTreeNode getLastPrefixNode(String prefix){
        PrefixTreeNode node = root;
        for(char ch:prefix.toCharArray()){
            PrefixTreeNode chNode = node.getNeighbor(ch);
            if(chNode == null){
                return null;
            }
            node = chNode;
        }
        return node;
    }

    class PrefixTreeNode{
        char val;
        Map<Character,PrefixTreeNode> neighbors;
        public PrefixTreeNode(char val){
            this.val = val;
            neighbors = new HashMap<>();
        }
        public char getValue(){
            return val;
        }
        public void addNeighbor(PrefixTreeNode neighbor){
            neighbors.put(neighbor.getValue(), neighbor);
        }
        public Map<Character,PrefixTreeNode> getNeighbors(){
            return neighbors;
        }
        public PrefixTreeNode getNeighbor(char val){
            return neighbors.get(val);
        }
    }
}


/***


root -> a/b/c/d.../x/y/z


root->d->o->g->null

How would I insert?

root->d
      ^

dog
 ^

Whether the neighbors of this node contain the current character

root=>()
()

Map<Character, Set<Character>>


TreeNode{

char val;
Set<TreeNode> neighbors;

}

If there are no neighbors/ there is no neighbor with that value
Then I'd create a new Node and then add it to the neighbors of the current node
Then move the current node to this new neighbor
If the neighbor existed, I'd have simply moved the current node to neighbor
And then I'll increment the pointer in my string as well

How do I check that current node has the required neighbor or not????
Map<TreeNode, Set<Character>>


        #
       /
*->d->o->g->#
    \
     d

I cannot store Map Character and TreeNode
Map<TreeNode, Set<TreeNode>> neighbors
But I can skip this as well?
Since for a given TreeNode, I'd already have access to its children/ neighbors






O(26)

At max there will be 26 neighbors to a node
*/