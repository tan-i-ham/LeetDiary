class Solution {
    int res;
    Map<Integer, List<Integer>> childMap;
    public int longestPath(int[] parent, String s) {
        res = 1;
        int N = parent.length;
        childMap = new HashMap<>();
        for(int i=1; i< N; i++){
            int par = parent[i];
            List<Integer> ogList = childMap.getOrDefault(par, new ArrayList<>());
            ogList.add(i);
            childMap.put(par, ogList);
        }
        
        dfs(0, s);
        return res;
    }
    public int dfs(int node, String s){
        if(!childMap.containsKey(node)){
            return 1;
        }
        int longestChain = 0, secondLongestChain = 0;
        for(int c: childMap.get(node)){
            int longestFromChild = dfs(c, s);
            
            if(s.charAt(node) == s.charAt(c)){
                continue;
            }
            if(longestFromChild > longestChain){
                secondLongestChain = longestChain;
                longestChain = longestFromChild;
            }else if(longestFromChild > secondLongestChain){
                secondLongestChain = longestFromChild;
            }
        }
        res = Math.max(res, longestChain + secondLongestChain + 1);
        return longestChain + 1; // only choose one path
    }
}