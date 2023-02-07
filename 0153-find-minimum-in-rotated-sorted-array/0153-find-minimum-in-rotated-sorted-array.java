class Solution {
    public int findMin(int[] nums) {
        int N = nums.length;
        int l = 0;
        int r = N - 1;
        
        while(l < r){
            int m = l + (r-l)/2;
            if(nums[l] < nums[r]){ // not roated  
                r = m - 1;
            }else{
                // rotated
                if(nums[m] < nums[r]){
                    r = m;
                }else{
                    l = m+1;    
                }
            }
        }
        return nums[l];
    }
}