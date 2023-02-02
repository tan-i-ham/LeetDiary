class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] newNums = new int[N+2];
        memo = new int[N+2][N+2];
        newNums[0] = 1;
        newNums[N+1] = 1;
        for(int i=1; i<=N; i++){
            newNums[i] = nums[i-1];
        }
        return dfs(newNums, 1, N);
    }
    public int dfs(int[] arr, int l, int r){
        if(l > r){
            return 0;
        }
        if(memo[l][r] > 0){
            return memo[l][r];
        }
        
        int res =0;
        for(int i=l; i<= r; i++){
            int currGain = arr[l-1] * arr[i] * arr[r+1];
            int remain = dfs(arr, l, i-1) + dfs(arr, i+1, r);
            res = Math.max(res, currGain + remain);
        }
        memo[l][r] = res;
        return res;
    }
}


