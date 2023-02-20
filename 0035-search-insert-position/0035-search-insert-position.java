class Solution {
    public int searchInsert(int[] nums, int target) {
        int N = nums.length;
        int l = 0;
        int r = N - 1;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}