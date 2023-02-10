class Solution {
    
    public int maxDistance(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int[][] dirs = new int[][]{ {1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] v = new boolean[rLen][cLen];
        Queue<int[]> q = new LinkedList<>();
        
        // loop for starting point
        for(int r=0; r< rLen; r++){
            for(int c=0; c< cLen; c++){
                
                // is water
                if(grid[r][c] == 1){
                    q.offer(new int[]{r, c});        
                    v[r][c] = true;
                }
            }
        }
        int dist = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();

                for(int[] dir: dirs){
                    int newR = curr[0] + dir[0];
                    int newC = curr[1] + dir[1];
                    if(newR>=0 && newR < rLen && newC >=0 && newC< cLen
                        && !v[newR][newC]){
                        q.offer(new int[]{newR, newC});
                        v[newR][newC] = true;
                    }
                }
            }
            dist++;
        }
        return dist ==0 ? -1: dist;
    }
}