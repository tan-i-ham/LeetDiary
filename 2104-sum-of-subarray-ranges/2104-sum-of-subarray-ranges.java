// min[i][j] = minimum number from i to j
// max[i][j] = maximum number from i to j
// ans = sum (max[i][j] - min[i][j])
class Solution {
    public long subArrayRanges(int[] nums) {
        
        int N = nums.length;
        int[][] min = new int[N][N];
        int[][] max = new int[N][N];
        long ans = 0;
        for(int s=0; s < N; s++){
            int minVal = nums[s];
            int maxVal = nums[s];
            for(int e=s; e < N; e++){
                minVal = Math.min(minVal, nums[e]);
                maxVal = Math.max(maxVal, nums[e]);
                
                ans += (maxVal - minVal);
            }
        }

        return ans;
    }
}

// [4,-2,-3,4,1]
// min=[
//     [4,-2,-3,-3,-3],
//     [0,-2,-3,-3,-3],
//     [0,0,-3,-3,-3],
//     [0,0,0,4,1],
//     [0,0,0,0,1]
// ]

// max=[
//     [4,4,4,4,4],
//     [0,-2,-2,4,4],
//     [0,0,-3,4,4],
//     [0,0,0,4,4],
//     [0,0,0,0,1]
// ]