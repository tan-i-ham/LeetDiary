class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        
        int[][] adj = new int[N][N]; // adj[i][j]: the distance between point i and j
        
        for(int i=0; i< N; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1; j< N; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) +  Math.abs(y1-y2);
                adj[i][j] = dist; 
                adj[j][i] = dist;
            }
        }
        
        Set<Integer> v = new HashSet<>(); // [idx]
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a,b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0}); // [dist, nodeIdx]
        
        int res = 0;
        while(v.size() < N){
            int[] curr = minHeap.poll();
            int dist = curr[0];
            int nodeIdx = curr[1];
            if(v.contains(nodeIdx)){
                continue;
            }
            res += dist;
            v.add(nodeIdx);
            for(int neighbor=0; neighbor<N; neighbor++){
                if(!v.contains(neighbor)){
                    minHeap.add(new int[]{ adj[nodeIdx][neighbor], neighbor});     
                }
            }
        }
        return res;
    }
}