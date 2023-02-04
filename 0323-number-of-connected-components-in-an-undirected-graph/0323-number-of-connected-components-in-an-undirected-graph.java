// adj
// when visit all the neighbor, but the visited set size still less than n, continue visit in the for loop in main func
class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> v;
    
    public int countComponents(int n, int[][] edges) {
        adj = new HashMap<>();
        v = new HashSet<>();
        int count = 0;
        
        for(int[] edge: edges){
            List<Integer> l1 = adj.getOrDefault(edge[0], new ArrayList<>());
            l1.add(edge[1]);
            adj.put(edge[0], l1);
            List<Integer> l2 = adj.getOrDefault(edge[1], new ArrayList<>());
            l2.add(edge[0]);
            adj.put(edge[1], l2);
        }
        
        for(int i=0; i< n; i++){
            if(v.size()==n){
                break;
            }
            if(v.contains(i)){
                continue;
            }
            dfs(i);
            count++;
        }
        return count;
    }
    
    public void dfs(int node){
        if(v.contains(node)){
            return;
        }
        v.add(node);
        if(!adj.containsKey(node)){
            return;
        }
        for(int n: adj.get(node)){
            dfs(n);
        }
        
    }
}