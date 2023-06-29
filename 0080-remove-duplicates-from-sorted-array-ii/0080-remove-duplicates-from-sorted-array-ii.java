class Solution {
    public int removeDuplicates(int[] nums) {
        int N = nums.length;
        int rIdx = 0;
        int count = 1;
        for(int i=1; i<N; i++){
            if(nums[i-1] == nums[i]){
                count++;
            }else{
                count=1;
            }

            if(count<= 2){
                rIdx++;
                nums[rIdx] = nums[i];  
            }
            
        }
        return rIdx+1;
    }
}

// nums = [1,1,1,2,2,3]
// i   rIdx
// 1   0
// 2   1
// 3   1
// 3   2   [1,1,2,2,2,3]

// 4   2
// 5   3
// 5   4   [1,1,2,2,3,3]

// nums = [0,0,1,1,1,1,2,3,3]
// i   rIdx
// 1   0
// 2   1
// 2   2

// 3   2
// 4   3
// 5   3
// 6   3
// 6   4   [0,0,1,1,2,1,2,3,3]

// 7   4
// 5   3
// 5   4   [1,1,2,2,3,3]

