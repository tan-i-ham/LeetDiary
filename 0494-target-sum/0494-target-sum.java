// helper(currIdx, currSum, target)
class Solution {
    int ans;
    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        helper(0, 0, target, nums);
        return ans;
    }
    public void helper(int currIdx, int currSum, int target, int[] nums){
        if(currIdx>= nums.length){
            if(currSum == target){
                ans++;
            }
            return;
        }
        
        helper(currIdx+1, currSum+nums[currIdx], target, nums);
        helper(currIdx+1, currSum-nums[currIdx], target, nums);
    }
}