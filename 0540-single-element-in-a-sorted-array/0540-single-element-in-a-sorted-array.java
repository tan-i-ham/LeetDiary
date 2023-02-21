class Solution {
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length;
        int l = 0;
        int r = N - 1;
        // [0,2,4,6]
        while(l < r){
            int mid = l + (r-l)/2;
            if(mid%2!=0){
                mid--;
            }
            if(mid%2==0){ // even
                if(nums[mid] == nums[mid+1]){
                    l = mid + 2;
                }else{
                    r = mid;
                }
            }
        }
        return nums[l];
    }
}