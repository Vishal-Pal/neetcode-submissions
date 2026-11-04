class WordDictionary {
    DictionaryNode root;
    public WordDictionary() {
        root = new DictionaryNode();
    }

    public void addWord(String word) {
        DictionaryNode node = root;
        for(char ch:word.toCharArray()){
            node = node.getOrAddNeighbor(ch);
        }
        node.setIsEndOfWord(true);
    }

    public boolean search(String word) {
        return search(word.toCharArray(), root, 0);
    }

    private boolean search(char[] wordArr, DictionaryNode node, int start){
        DictionaryNode curr = node;
        for(int ind=start;ind<wordArr.length;ind++){
            char ch = wordArr[ind];
            if(ch == '.'){
                for(DictionaryNode neighbor:curr.getNeighbors()){
                    if(search(wordArr, neighbor, ind+1)){
                        return true;
                    }
                }
                return false;
            }
            curr = curr.getNeighbor(ch);
            if(curr == null){
                return false;
            }
        }
        return curr.isEndOfWord();
    }

    class DictionaryNode{
        DictionaryNode[] neighbors;
        boolean isEndOfWord;
        public DictionaryNode(){
            neighbors = new DictionaryNode[26];
        }
        public DictionaryNode getNeighbor(char ch){
            return neighbors[getIndex(ch)];
        }
        public DictionaryNode getOrAddNeighbor(char ch){
            int ind = getIndex(ch);
            return neighbors[ind] == null ? neighbors[ind] = new DictionaryNode():neighbors[ind];
        }
        private int getIndex(char ch){
            return ch-'a';
        }
        public List<DictionaryNode> getNeighbors(){
            return Arrays.stream(neighbors).filter(Objects::nonNull).collect(Collectors.toList());
        }
        public boolean isEndOfWord(){
            return isEndOfWord;
        }
        public void setIsEndOfWord(boolean isEndOfWord){
            this.isEndOfWord = isEndOfWord;
        }
    }
}
