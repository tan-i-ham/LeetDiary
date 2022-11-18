class Solution {
    public int countSubstrings(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        
        int ans = 0;
        for(int start=N-1; start >=0; start--){
            for(int end=start; end < N; end++){
                if(s.charAt(start) == s.charAt(end)){
                    if(end - start <= 2 || dp[start+1][end-1]){
                        dp[start][end] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}