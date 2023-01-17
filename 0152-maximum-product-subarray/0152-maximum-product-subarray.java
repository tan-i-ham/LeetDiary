class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        int minSoFar = nums[0];
        int maxSoFar = nums[0];
        int curr = nums[0];
        
        int res = nums[0];
        for(int i=1; i< N; i++){
            curr = nums[i];
            int tempMinSoFar = Math.min(curr, Math.min(minSoFar* curr, maxSoFar * curr));
            int tempMaxSoFar = Math.max(curr, Math.max(minSoFar* curr, maxSoFar * curr));
            minSoFar = tempMinSoFar;
            maxSoFar = tempMaxSoFar;
            res = Math.max(res, maxSoFar);
        }

        return res;
    }
}
//     2       2
// i   prev    ans
// 1   6       2
// 2   -2      6
// 3   4     6

//     -2      -2
// i   prev    ans
// 1   0       -2
// 2   -1      0