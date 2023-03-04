// minIdx = [0]
// maxIdx = [2,5]
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int N = nums.length;
        int minKPos = -1;
        int maxKPos = -1;
        int leftBound = -1;
        long count = 0;
        for(int i=0; i< N; i++){
            if(nums[i]  > maxK || nums[i] < minK){
                leftBound = i;
            }
            if(nums[i] == minK){
                minKPos = i;
            }
            if(nums[i] == maxK){
                maxKPos = i;
            }
            int smallerIdx = Math.min(minKPos, maxKPos);
            count += Math.max(0, smallerIdx-leftBound);            
        }
        
        return count;
    }
}

// [0,6,10]
// [2,3,5,7,9]

// [0-2] (3-14) : 12
// [0-3] (4-14) : 11
// [0-5] (6-14) : 9
// [0-7] (8-14) : 6
// [0-9] (10-14) :5    
// [2-6] (7-14) : 8
// [3-6] (7-14) : 8 
// [5-6] (7-14) : 8
// [6-7] (8-14):  7
// [6-9] (10-14): 5
// [2-10](11-14): 4
// [3-10](11-14): 4
// [5-10](11-14): 4    
// [7-10](11-14): 4
// [9-10](11-14): 4    
    