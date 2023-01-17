// canBreak[i]: the string s can be seperated by the word in dict at i-th character
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] canBreak = new boolean[N+1];
        canBreak[0] = true;
        
        for(int i=0; i< N; i++){
            for(String word: wordDict){
                int wordLen = word.length();
                if(i+wordLen > N){
                    continue;
                }
                String splitPart = s.substring(i, i+wordLen);
                if(splitPart.equals(word)){
                    canBreak[i+wordLen] = canBreak[i+wordLen] || canBreak[i];
                }
            }
        }
        // System.out.println(Arrays.toString(canBreak));
        
        return canBreak[N];
    }
}