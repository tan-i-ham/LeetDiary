class Solution {
    public int numSplits(String s) {
        int N = s.length();
        
        int[] leftSize = new int[N+1];
        int[] rightSize = new int[N+1];
        
        Set<Character> lSet = new HashSet<>();
        Set<Character> rSet = new HashSet<>();
        
        for(int i=0; i< N; i++){
            lSet.add(s.charAt(i));
            leftSize[i] = lSet.size();
        }
        for(int i=N-1; i >=0 ; i--){
            rSet.add(s.charAt(i));
            rightSize[i] = rSet.size();
        }        
        int ans = 0;
        for(int i=0; i< N; i++){
            if(leftSize[i] == rightSize[i+1]){
                ans++;
            }
        }
        return ans;
    }
}