class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        int furtherestIdx = 0;
        // if(N==1){
        //     return true;
        // }
        for(int i=0; i< N; i++){
            if(furtherestIdx < i){
                return false;
            }
            furtherestIdx = Math.max(i + nums[i], furtherestIdx);
            if(furtherestIdx >= N-1){
                return true;
            }
        }
        return false;
    }
}