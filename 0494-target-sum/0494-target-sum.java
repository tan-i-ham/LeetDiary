class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int N = nums.length;
        int[][] dp = new int[N][total*2 + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;
        for (int idx=1; idx < N; idx++) {
            for (int sum=-total; sum<= total; sum++) {
                if(dp[idx-1][sum+total] >0){
                    dp[idx][sum + total + nums[idx] ] += dp[idx-1][sum + total];
                    dp[idx][sum + total - nums[idx] ] += dp[idx-1][sum + total];
                }
            }
        }
        
        return Math.abs(target) > total ?0: dp[N-1][target + total];
    }
}

// TC: O(total * N), N is the length of nums
// SC: O(total * N)