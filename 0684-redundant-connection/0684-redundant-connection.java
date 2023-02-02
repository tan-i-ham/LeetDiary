// create adjancency list
// {1: [2,3], 2:[1,3] 3:[1,2]}
class Solution {
    Set<Integer> v = new HashSet<>();
    
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length - 1;
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] edge: edges){
            v.clear();
            if(adj.containsKey(edge[0]) && adj.containsKey(edge[1])
              && hasCycle(adj, edge[0], edge[1], v)){
                return edge;
            }
            List<Integer> l1 = adj.getOrDefault(edge[0], new ArrayList<>());
            l1.add(edge[1]);
            adj.put(edge[0], l1);
            
            List<Integer> l2 = adj.getOrDefault(edge[1], new ArrayList<>());
            l2.add(edge[0]);
            adj.put(edge[1], l2);
        }
        
     
        return null;
    }
    
    public boolean hasCycle(Map<Integer, List<Integer>> adj, int src, int target, Set<Integer> v){
        if(!v.contains(src)){
            v.add(src);
            if(src==target){
                return true;
            }
            for(int neighbor: adj.get(src)){
                if(hasCycle(adj, neighbor, target, v)){
                    return true;
                }
            }
        }
        return false;
    }
}