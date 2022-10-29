class WordDictionary {

    class TrieNode{
        TrieNode[] child;
        boolean isEnd;
        
        public TrieNode(){
            child = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.child[ch - 'a']==null){
                curr.child[ch - 'a'] = new TrieNode();
            }
            curr = curr.child[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word.toCharArray(), 0, root);
    }
    
    public boolean searchInNode(char[] chs, int k, TrieNode node) {
        if (k == chs.length) {
            return node.isEnd;   
        }
        if (chs[k] != '.') {
            return node.child[chs[k] - 'a'] != null 
                && searchInNode(chs, k + 1, node.child[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.child.length; i++) {
                if (node.child[i] != null) {
                    if (searchInNode(chs, k + 1, node.child[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */