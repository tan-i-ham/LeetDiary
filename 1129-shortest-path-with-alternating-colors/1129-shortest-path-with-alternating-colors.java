class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] re: redEdges){
            List<int[]> l = adj.getOrDefault(re[0], new ArrayList<>());
            l.add(new int[]{re[1], 0});
            adj.put(re[0], l);
        }
        for(int[] be: blueEdges){
            List<int[]> l = adj.getOrDefault(be[0], new ArrayList<>());
            l.add(new int[]{be[1], 1});
            adj.put(be[0], l);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,-1}); // [node, pathLen, color]
        boolean[][] v = new boolean[n][2]; // [node, color]
        v[0][0] = true;
        v[0][1] = true;
        while(!q.isEmpty()){
            int[] currState = q.poll();
            int node = currState[0];
            int pathLen = currState[1];
            int color = currState[2];

            if(!adj.containsKey(node)){
                continue;
            }
            for(int[] neiState: adj.get(node)){
                int nextNode = neiState[0];
                int nextColor = neiState[1];
                if(!v[nextNode][nextColor]
                  && color != nextColor){
                    if(ans[nextNode] == -1){
                        ans[nextNode] = pathLen + 1;
                    }
                    v[nextNode][nextColor] = true;
                    q.add(new int[]{nextNode, pathLen+1, nextColor});
                }
            }
        }
        return ans;
    }
}