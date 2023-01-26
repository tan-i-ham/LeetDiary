class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length;
        int[] dp = new int[amount+1]; // dp[i]: the number of combinations to make up the i amount
        dp[0] = 1; //  the number of combinations to make up the 0 amount
        for(int i=0; i< N; i++){
            for(int val=coins[i]; val <= amount; val++){
                dp[val] = dp[val] + dp[val-coins[i]];
            }
        }
        return dp[amount];
    }
}
// i   val dp
// 0   1   [1,1,0,0,0,0]
//     2   [1,1,1,0,0,0]
//     ..
//     5   [1,1,1,1,1,1]
// 1   2   [1,1,2,1,1,1]  2=1+1 = 2+0
//     3   [1,1,2,2,1,1]  3=1+1+1 = 1+2
//     4   [1,1,2,2,3,1]  4=1+1+1+1 = 1+1+2 = 2+2  
//     5   [1,1,2,2,3,3]
// 2   5   [1,1,2,2,3,4]

// TC: O(amount*N)
// SC: O(amount)