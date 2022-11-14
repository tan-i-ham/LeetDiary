class Solution {
    public boolean shareColOrRow(int[] src, int[] dst){
        return src[0] == dst[0] || src[1] == dst[1];
    }
    public int removeStones(int[][] stones) {
        int N = stones.length;
        List<Integer>[] adjList = new ArrayList[N];
        
        for(int i=0; i< N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i< N; i++){
            for(int j=i+1; j< N; j++){
                if(shareColOrRow(stones[i], stones[j])){
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        boolean[] v = new boolean[N];
        int count = 0;
        for(int i=0; i< N; i++){
            if(!v[i]){
                count++;
                dfs(stones, adjList, v, i);
            }
        }
        return N - count;
    }
    
    public void dfs(int[][] stones, List<Integer>[] adjList, boolean[] v, int idx){
        v[idx] = true;
        for(int neighbor: adjList[idx]){
            if(!v[neighbor]){
                dfs(stones, adjList, v, neighbor);
            }
        }
        
    }
}