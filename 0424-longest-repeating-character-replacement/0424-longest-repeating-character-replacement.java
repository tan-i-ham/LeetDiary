class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        Set<Character> allLetters = new HashSet<>();
        for(char ch: s.toCharArray()){
            allLetters.add(ch);
        }
        
        int maxLen = 1;
        
        for(char ch='A'; ch <= 'Z'; ch++){
            if(allLetters.contains(ch)){
                int start = 0;
                int count = 0;
                for(int end=0; end < N; end++){ // expand the window size
                    if(s.charAt(end) == ch){
                        count++;
                    }
                    while(!isWindowValid(start, end, count, k)){
                        if(s.charAt(start) == ch){ // shrink the window size
                            count--;
                        }
                        start++;
                    }
                    maxLen = Math.max(maxLen, end - start +1);
                }
            }
        }
        return maxLen;
    }
    
    public boolean isWindowValid(int start, int end, int count, int k){
        return end - start + 1 - count <= k;
    }
}

// TC: O(N*26)
// SC: O(26) // the set's size