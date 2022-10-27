//         root
//       a
//     p
//   p
// /
// l hasWord
// |
// e
// |
// hasWord

class Trie {

    class TrieNode{
        TrieNode[] childs;
        boolean hasWord;
        
        public TrieNode(){
            childs = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.childs[ch-'a']==null){
                curr.childs[ch-'a'] = new TrieNode();  
            }
            curr = curr.childs[ch-'a'];
        }
        curr.hasWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.childs[ch-'a']==null){
                return false;
            }
            curr = curr.childs[ch-'a'];
        }    
        return curr.hasWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch: prefix.toCharArray()){
            if(curr.childs[ch-'a']==null){
                return false;
            }
            curr = curr.childs[ch-'a'];
        }    
        return true;        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */