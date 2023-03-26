class Solution {
    Map<Integer, Integer> dist;
    int N;
    boolean[] v;
    int ans;
    public int longestCycle(int[] edges) {
        dist = new HashMap<>();
        N = edges.length;
        v = new boolean[N];
        ans = -1;
        
        boolean isFound = false;
        
        for(int src=0; src< N; src++){
            if(!v[src]){
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(src, 0);
                dfs(src, edges, dist);
            }
        }   
        return ans;
    }
    
    public void dfs(int node, int[] edges, Map<Integer, Integer> dist){
        
        v[node] = true;
        int neighbor = edges[node];
        
        if(neighbor != -1){
            if(!v[neighbor]){
                int prev = dist.get(node);
                dist.put(neighbor, prev+1); 
                dfs(neighbor, edges, dist);    
            }else if(dist.containsKey(neighbor)){
                ans = Math.max(ans, dist.get(node) - dist.get(neighbor) + 1);
            }
        }
    }
}

// TC: O(n)
// SC: O(n)