class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int ans = 1;
        for(int i=0; i< N; i++){
            dp[i] = 1; //green color in the solution
            for(int j=0; j< i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

// TC: O(N^2)
// SC: O(N)