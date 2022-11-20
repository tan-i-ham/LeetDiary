class Solution {
     boolean[][] v;
    public int numIslands(char[][] grid) {
        int ans = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        
        v = new boolean[rowLen][colLen];
        for(int r=0; r< rowLen; r++){
            for(int c=0; c< colLen; c++){
                if(!v[r][c] && grid[r][c]=='1'){
                    dfs(grid, r, c);
                    ans++;
                }        
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return;
        }
        if(v[row][col]){
            return;
        }
        v[row][col] = true;
        if(grid[row][col] == '0'){
            return;
        }
        
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
}