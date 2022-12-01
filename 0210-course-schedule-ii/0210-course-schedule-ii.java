class Solution {
    List<Integer> output;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] pre: prerequisites){
            List<Integer> l = map.getOrDefault(pre[0], new ArrayList<>());
            l.add(pre[1]);
            map.put(pre[0], l);
        }
        output = new ArrayList<>();
        Set<Integer> cycle = new HashSet<>();
        Set<Integer> v = new HashSet<>();
        for(int i=0; i< numCourses; i++){
            if(!dfs(i, map, cycle, v) ) {
                return new int[0];
            }
        }

        return output.stream().mapToInt(i->i).toArray();
    }
    public boolean dfs(int cNum, Map<Integer, List<Integer>> map, Set<Integer> cycle, Set<Integer> v){
        if(cycle.contains(cNum)){
            return false;
        }
        if(v.contains(cNum)){
            return true;
        }
        if(map.containsKey(cNum)){
            cycle.add(cNum);
            for(int pre: map.get(cNum)){
                if(!dfs(pre, map, cycle, v) ){
                    return false;
                }
            }
            cycle.remove(cNum);
        }
        v.add(cNum);
        output.add(cNum);
        return true;
    }
}
// TC: O(N + len(pre)) == V + E
// SC: O(N + len(pre)) == V + E