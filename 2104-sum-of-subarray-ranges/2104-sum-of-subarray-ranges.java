// min[i][j] = minimum number from i to j
// max[i][j] = maximum number from i to j
// ans = sum (max[i][j] - min[i][j])
class Solution {
    public long subArrayRanges(int[] nums) {
        
        int N = nums.length;
        int[][] min = new int[N][N];
        int[][] max = new int[N][N];
        for(int s=0; s < N; s++){
            for(int e=s; e < N; e++){
                if(s==e){
                    min[s][e] = nums[e];
                    max[s][e] = nums[e];
                }else{
                    min[s][e] = Math.min(min[s][e-1], nums[e]);
                    max[s][e] = Math.max(max[s][e-1], nums[e]);
                }
            }
        }

  
        long ans = 0;
        for(int s=0; s < N; s++){
            for(int e=s; e < N; e++){
                ans += (max[s][e] - min[s][e]);
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