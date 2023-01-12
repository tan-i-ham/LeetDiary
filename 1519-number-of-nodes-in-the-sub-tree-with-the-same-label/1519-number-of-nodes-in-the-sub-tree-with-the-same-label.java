class Solution {
    int[] ans;
    Map<Integer, List<Integer>> adj;
         
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];
        adj = new HashMap<>();
        for(int[] edge: edges){
            List<Integer> ogList = adj.getOrDefault(edge[0], new ArrayList<>());
            ogList.add(edge[1]);
            adj.put(edge[0], ogList);
            
            List<Integer> ogList2 = adj.getOrDefault(edge[1], new ArrayList<>());
            ogList2.add(edge[0]);
            adj.put(edge[1], ogList2);
        }
        dfs(0, -1, labels);
        return ans;
    }
    
    public Map<Character, Integer> dfs(int node, int parent, String labels){ 
        char ch = labels.charAt(node);
        Map<Character, Integer> map = new HashMap<>();
        map.put(ch, 1); // self
        
        for(int child: adj.get(node)){
            if(child==parent){
                continue;
            }
            Map<Character, Integer> res = dfs(child, node, labels);
            for(Map.Entry<Character, Integer> entry: res.entrySet()){
                if(!map.containsKey(entry.getKey())){
                    map.put(entry.getKey(), entry.getValue());
                }else{
                    char temp = entry.getKey();
                    int og = map.get(temp);
                    map.put(temp, entry.getValue() + og);
                }
            }            
        }

        ans[node] = map.get(ch);
        // System.out.println(node);
        // System.out.println(map);
        // System.out.println("==========");
        return map;
    }
}

// dfs(0,-1,)
//     dfs(1,0) -> {'b':2}, ans[1] = 2
//         dfs(2,1) -> {'b':1}, ans[2] = 1
//         map={'b': 2} // node 0
//     dfs(3,0) -> {'b':1}, ans[3] = 1
//         map={'b': 3} // node 0
