class Solution {
    int[] memo;
    public int jump(int[] nums) {
        memo = new int[10001];
        Arrays.fill(memo, 10001);
        int N = nums.length;
        if(N==1){
            return 0;
        }
        return jump(nums, 0);
    }
    public int jump(int[] nums, int currIdx){
        if(currIdx >= nums.length - 1){
            return 0;
        }
        if(memo[currIdx]!=10001){
            return memo[currIdx];
        }
        int min = 10001;
        for(int step=1; step <= nums[currIdx]; step++){
            min = Math.min(min, 1 + jump(nums, currIdx+step));
        }
        memo[currIdx] = min;
        return min;
    }
}
// before memo array
// TC: O(N!)
// SC: O(N)
// after memo array
// TC: O(N^2)
// SC: O(N)
