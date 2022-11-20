// bfs
// 2 for loop, when grid[r][c] is 1, start bfs and count the island area
// store max area
class Solution {
    boolean[][] v;
    public int maxAreaOfIsland(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        v = new boolean[rl][cl];
        int maxArea = 0;
        for(int r=0; r< rl; r++){
            for(int c=0; c< cl; c++){
                if(!v[r][c] && grid[r][c] == 1){
                    int currA = bfs(grid, r, c);
                    maxArea = Math.max(currA, maxArea);
                }
            }
        }
        return maxArea;
    }
    
    public int bfs(int[][] grid, int row, int col){
        int rl = grid.length;
        int cl = grid[0].length;
        int area = 0;
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{row, col});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                if(v[r][c]){
                    continue;
                }
                area++;
                v[r][c] = true;
                if(r-1 >=0 && !v[r-1][c] && grid[r-1][c]==1){
                    q.add(new int[]{r-1, c});
                }
                if(r+1 < rl && !v[r+1][c]  && grid[r+1][c]==1){
                    q.add(new int[]{r+1, c});
                }
                if(c-1 >=0 && !v[r][c-1]&& grid[r][c-1]==1){
                    q.add(new int[]{r, c-1});
                }
                if(c+1 < cl && !v[r][c+1]&& grid[r][c+1]==1){
                    q.add(new int[]{r, c+1});
                }                
            }
        }
        return area;
    }
}