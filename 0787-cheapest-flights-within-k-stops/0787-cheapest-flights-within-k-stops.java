class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] f: flights){
            int s = f[0];
            int d = f[1];
            int cost = f[2];
            adj.putIfAbsent(s, new ArrayList<>());
            adj.get(s).add(new int[]{d, cost});
        }
        int[] minCost = new int[n+1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});

        int stop = 0;
        while(!q.isEmpty() && stop <= k){
            int size = q.size();
            for(int i=0; i< size; i++){
                int[] curr = q.poll();
                int node = curr[0];
                int currCost = curr[1];
                if(!adj.containsKey(node)){
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int[] nextStop: adj.get(node)){
                    int neighbor = nextStop[0];
                    int nextCost = nextStop[1];
                    if(currCost + nextCost < minCost[neighbor]){
                        minCost[neighbor] = currCost + nextCost;
                        q.add(new int[]{neighbor, minCost[neighbor]});
                    }
                }
            }
            stop++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
// TC: O(NK + V)
// SC: O(V)