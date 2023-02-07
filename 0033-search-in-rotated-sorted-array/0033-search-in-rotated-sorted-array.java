class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;
        int l = 0;
        int r = N - 1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] <= nums[r]){ // right side ordered
                if(target >= nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            if(nums[l] <= nums[mid]){ // left side ordered
                if(target >= nums[l] && target <= nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }           
        }
        return -1;
    }
}