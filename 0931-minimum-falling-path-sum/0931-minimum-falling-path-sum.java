class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        
        for(int r=1; r< rLen; r++){
            for(int c=0; c< cLen; c++){
                // int currNum = matrix[r][c];
                int prevMin = matrix[r-1][c];
                if(c>0){
                    prevMin = Math.min(prevMin, matrix[r-1][c-1]);
                }
                if(c < cLen-1){
                    prevMin = Math.min(prevMin, matrix[r-1][c+1]);
                }
                matrix[r][c] += prevMin;
            }
        }
        int ans = matrix[rLen-1][0];
        for(int c=1; c< cLen; c++){
            ans = Math.min(ans, matrix[rLen-1][c]);
        }
        return ans;
    }
}

// 2 1 3
// 7 6 5
// 13 13 14