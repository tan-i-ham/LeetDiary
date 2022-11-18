// backtrack, base case, 0 return 1
// n=45, TLE
// use map to store the counted value, e.g. key is n, value is the ways to climb to the top
// dp[i] = the ways to climb to the i-th step
class Solution {
    
    public int climbStairs(int n) {
        if(n==0){
            return 1;
        }        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<= n; i++ ){
            // choose either climb 1 step or 2 steps
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}