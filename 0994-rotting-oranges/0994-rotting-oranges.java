// bfs
// first, add all the cell that is rotten 2 to the queue
// second, start the while loop, if neighbor has orange than add the cell the queue
// min + 1 in every size
class Solution {
    public int orangesRotting(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean hasRotten = false;
        for(int r=0; r< rLen; r++){
            for(int c = 0; c < cLen; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                    hasRotten = true;
                    grid[r][c] = 0;
                }
            }
        }

        int min = -1;
        while(!q.isEmpty()){
            min++;
            int size = q.size();
            for(int i=0; i< size; i++){
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                
                if(row+1 >=0 && row+1 < rLen && grid[row+1][col]==1){
                    q.offer(new int[]{row+1, col});
                    grid[row+1][col] = 0;
                }
                if(row-1 >=0 && row-1 < rLen && grid[row-1][col]==1){
                    q.offer(new int[]{row-1, col});
                    grid[row-1][col] = 0;
                }
                if(col+1 >=0 && col+1 < cLen && grid[row][col+1]==1){
                    q.offer(new int[]{row, col +1});
                    grid[row][col+1] = 0;
                }                
                if(col-1 >=0 && col-1 < cLen && grid[row][col-1]==1){
                    q.offer(new int[]{row, col -1});
                    grid[row][col-1] = 0;
                }    
                
            }
        }
        for(int r=0; r< rLen; r++){
            for(int c = 0; c < cLen; c++){
                if(grid[r][c] !=0){
                    return -1;
                }
            }
        }       
        if(!hasRotten){
            return 0;
        }        
        return min;
    }
}

// TC: O(MN)
// SC: O(MN), all rotten