class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;

        int ans = 0;
        int twoSteps= 0;
        int oneStep = 0;
        for(int i=2; i<= N; i++){
            int temp = oneStep;
            oneStep = Math.min(oneStep + cost[i-1], twoSteps + cost[i-2]);
            twoSteps = temp;
        }
        return oneStep;
    }
}

// [1,100,1,1,1,100,1,1,100,1]
//     0       0
// i   oneStep twoSteps
// 2   1       0
// 3   2       1
// 4   2       2
// 5   3       2
// 6   3       3  
// 7   4       3
// 8   4       4 
// 9   5       4       
// 10  6       5