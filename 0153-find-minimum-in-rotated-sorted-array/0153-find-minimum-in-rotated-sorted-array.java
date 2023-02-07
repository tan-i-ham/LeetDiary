class Solution {
    public int findMin(int[] nums) {
        int N = nums.length;
        int l = 0;
        int r = N - 1;
        
        if(nums[l] < nums[r]){ // not rotated  
            return nums[l];
        }
        while(l < r){
            int m = l + (r-l)/2;
            // rotated
            if(nums[m] < nums[r]){
                r = m;
            }else{
                l = m+1;    
            }
        }
        return nums[l];
    }
}