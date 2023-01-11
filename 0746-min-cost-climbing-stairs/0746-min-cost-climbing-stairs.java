class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N+1]; // dp[i]: the min cost to i th stair

        
        for(int i=2; i<= N; i++){
            int oneStep = dp[i-2] + cost[i-2];
            int twoSteps = dp[i-1] + cost[i-1];
            dp[i] = Math.min(oneStep, twoSteps);
        }
        return dp[N];
    }
}

// [1,100,1,1,1,100,1,1,100,1]
// i=2, [0,0,1,..]
// i=3, [0,0,1,2, ...]
// i=4, [0,0,1,2,2,..]
// i=5, [0,0,1,2,2,3,.]
// i=6, [0,0,1,2,2,3,3, ]
// i=7, [0,0,1,2,2,3,3,4 ]    
// i=8, [0,0,1,2,2,3,3,4,4, ]    
// i=9, [0,0,1,2,2,3,3,4,4,5]      