class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        int idx = nums.length;
        for(int i=0;  i<k; i++){
            idx--;
        }
        return nums[idx];
    }
}

// TC: O(NlogN), N is the length of nums
// SC: O(1)