// helper(currIdx, currSum, target)
class Solution {

    int total;
    int[][] memo;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        
        memo = new int[nums.length][total*2 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helper(0, 0, target, nums);
    }
    public int helper(int currIdx, int currSum, int target, int[] nums){
        if(currIdx>= nums.length){
            if(currSum == target){
                return 1;
            }
            return 0;
        }
        if(memo[currIdx][currSum + total] != Integer.MIN_VALUE){
            return memo[currIdx][currSum + total];
        }
        
        int addOption = helper(currIdx+1, currSum+nums[currIdx], target, nums);
        int substractOption = helper(currIdx+1, currSum-nums[currIdx], target, nums);
        memo[currIdx][currSum + total] = addOption + substractOption;
        return memo[currIdx][currSum + total];
    }
}

// TC: O(total * N), N is the length of nums
// SC: O(total * N)