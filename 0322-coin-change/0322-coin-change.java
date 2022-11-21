// dp[i]: the min coin number to make i value
//
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int a=1; a<=amount; a++){
            int curr = Integer.MAX_VALUE;
            for(int coin: coins){
                if(coin<=a && dp[a-coin]!=-1){
                    curr = Math.min(curr, 1 + dp[a-coin]);
                }
            }
            dp[a] = curr==Integer.MAX_VALUE? -1: curr;
        }
        return dp[amount];
    }
}