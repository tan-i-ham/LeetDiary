class Solution {
    boolean[][] v;
    int rLen;
    int cLen;
    int total;
    int ans;
    int[] start;
    public int uniquePathsIII(int[][] grid) {
        ans = 0;
        rLen = grid.length;
        cLen = grid[0].length;
        v = new boolean[rLen][cLen];
        
        start = new int[2];

        // count obstacle
        int obstacles = 0;
        for(int r=0; r< rLen; r++){
            for(int c=0; c< cLen; c++){
                if(grid[r][c] == -1){
                    obstacles++;
                }else if(grid[r][c] == 1){
                    start[0] = r;
                    start[1] = c;
                }
            }
        }
        total = rLen * cLen - obstacles;
        // System.out.println(Arrays.toString(start));
        dfs(grid, start[0], start[1], 0);
        return ans;
    }
    
    public void dfs(int[][] grid, int r, int c, int walked){
        if(r < 0 || c < 0 || r >= rLen || c >= cLen){
            return;
        }
        if(grid[r][c] == -1){
            return;
        }       
        if(v[r][c]){
            return;
        }
        if(grid[r][c]==2 && total == walked+1){
            ans++;
            return;
        }  
    

        v[r][c] = true;
        dfs(grid, r+1, c, walked+1);
        dfs(grid, r-1, c, walked+1);
        dfs(grid, r, c+1, walked+1);
        dfs(grid, r, c-1, walked+1);
        if(r==start[0] && c== start[1]){
               
        }else{
            v[r][c] = false; 
        }
        
    }
}