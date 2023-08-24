class Solution {
    public int minCost(int[][] costs) {
        int numHouses = costs.length;
        // 0: red, 1: blue, 2: green
        int[][] dp = new int[numHouses][3]; // dp[i][0]: the min cost when paint red in ith house
        // paint red on ith house: dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
        // paint blue on ith house: dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
        // paint green on ith house: dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
        
        // initalization
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i=1; i< numHouses; i++){
            for(int color=0; color <=2; color++){
                if(color == 0){
                    dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);    
                }else if(color == 1){
                    dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);    
                }else{
                    dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);    
                }
            }
        }
        int last = numHouses - 1;
        return Math.min( dp[last][2], Math.min(dp[last][0], dp[last][1]) );
    }
}

// TC: O(3*N) -> O(N)
// SC: O(3*N) -> O(N)