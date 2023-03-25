class Solution {
    public class UnionFind {
        int[] root;
        int[] rank;
        public UnionFind(int n){
            root = new int[n];
            rank = new int[n];
            for(int i=0; i< n; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int node){
            if(root[node] == node){
                return node;
            }
            return root[node] = find(root[node]);
        }
        
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX; 
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
        
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        Map<Integer, Integer> cntByRoot = new HashMap<>();
        for(int i=0; i<n; i++){
            int r = uf.find(i);
            int ogCnt = cntByRoot.getOrDefault(r, 0);
            cntByRoot.put(r, ogCnt+1);
        }
        
        long cnt = 0;
        long ramiainingNode = n;
        for(int groupCnt : cntByRoot.values()){
            cnt += groupCnt * (ramiainingNode - groupCnt);
            ramiainingNode -= groupCnt;
        }
        return cnt;       
    }
}