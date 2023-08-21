class Solution {
    List<List<Integer>> ans;
    int endNode;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        endNode = graph.length -1;
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        helper(0, currPath, graph);

        return ans;
    }
    
    public void helper(int node, List<Integer> currPath, int[][] graph){
        if(node==endNode){
            ans.add(new ArrayList<>(currPath));
            return;  
        } 
        int[] nextNodes = graph[node];
        for(int n: nextNodes){
            currPath.add(n);
            helper(n, currPath, graph);
            currPath.remove(currPath.size()-1);
        }
    }
}