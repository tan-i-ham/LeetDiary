// max: the answer, init set to the first element of array
// currSum: the sum of subarray that still be counted
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];
        for(int i=1; i< nums.length; i++){
            if(nums[i] > currSum && currSum <0){
                currSum = nums[i];
            }else{
                currSum += nums[i];
            }
            max = Math.max(currSum, max);
        }
        return max;
    }
}

// currSum max
// -2      -2
// 1       1
// -2      1
// 4       4
// 3       4
// 5       5
// 6       6
// 1       6
// 4       6