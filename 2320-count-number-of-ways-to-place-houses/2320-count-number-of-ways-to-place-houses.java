class Solution {
    
    public int countHousePlacements(int n) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n+1]; //dp[i] means with i plot, there has dp[i] ways that match with the condtraints
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<=n ; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        // System.out.println(dp[n]);
        return (int) (1L* dp[n] * dp[n] % MOD);
    }
}