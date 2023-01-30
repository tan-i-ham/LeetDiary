// base case: 
// 1. when idx is outside of matrix,
// 2. when curr number is smaller or equal to prev number
// 
class Solution {
    int ans;
    int rLen;
    int cLen;
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        rLen = matrix.length;
        cLen = matrix[0].length;
        ans = 1;
        memo = new int[rLen][cLen];
        for(int r=0; r< rLen; r++){
            for(int c=0; c< cLen; c++){
                ans = Math.max(ans, dfs(matrix, r, c, -1));
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int row, int col, int prev){
        
        if(row < 0 || col < 0 || row >= rLen || col >= cLen){
            return 0;
        }
        if(matrix[row][col] <= prev){
            return  0;
        }
        if(memo[row][col] !=0){
            return memo[row][col];
        }

       
        int res = 0;
        res = Math.max(res, 1 + dfs(matrix, row+1, col, matrix[row][col]));
        res = Math.max(res, 1 + dfs(matrix, row-1, col, matrix[row][col]));
        res = Math.max(res, 1 + dfs(matrix, row, col+1, matrix[row][col]));
        res = Math.max(res, 1 + dfs(matrix, row, col-1, matrix[row][col]));
        memo[row][col] =  Math.max(memo[row][col], res);
        return res;
    }
}

// dfs(0,0,-1,0)
//     dfs(0,1,3,1)
//         dfs(0,2,4,2)
//             dfs(1,2,5,3)
//                 dfs(1,1,6,4)