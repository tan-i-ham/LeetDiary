// bfs
// start with if the cell's value is gate
// create 1 queue, one keeps the idx of cell
// add the non wall and gate to queue
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rLen = rooms.length;
        int cLen = rooms[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for(int r=0; r< rLen; r++){
            for(int c=0; c < cLen; c++){
                if(rooms[r][c]==0){
                    q.offer(new int[]{r, c});
                }
            }
        }
        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i=0; i< size; i++){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                for(int[] dir: dirs){
                    if(r+dir[0] < 0 || r+dir[0] == rLen || c+dir[1] < 0 || c+ dir[1] == cLen
                      || rooms[r+dir[0]][c+dir[1]] != 2147483647){
                        continue;
                    }
                    q.offer(new int[]{r+dir[0], c+dir[1]});
                    rooms[r+dir[0]][c+dir[1]] = dist;
                }
            }
        }

    }
}