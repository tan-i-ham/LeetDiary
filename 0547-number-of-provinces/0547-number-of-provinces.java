class Solution {
    class UnionFind {
        int[] root;
        int[] rank;
        public UnionFind(int size){
            root = new int[size+1];
            rank = new int[size+1];
            for(int i=1; i<=size; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int vertex){
            if(root[vertex] == vertex){
                return vertex;
            }
            
            return root[vertex] = find(root[vertex]);
        }
        
        public void union(int v1, int v2){
            int root1 = find(v1);
            int root2 = find(v2);
            if(root1 != root2){
                if(rank[root1] > rank[root2]){
                    root[root2] = root1;
                }else if(rank[root1] < rank[root2]){
                    root[root1] = root2;
                }else{
                    root[root2] = root1;
                    rank[root1]++;
                }
            }
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        UnionFind uf = new UnionFind(N);
        for(int r=0; r< N; r++){
            for(int c=0; c< N; c++){
                if(isConnected[r][c] == 1){
                    uf.union(r+1, c+1);    
                }    
            }
        }
        int ans = 0;
        for(int i=1; i<=N; i++){
            if(i == uf.find(i)){
                ans++;
            }
        }
        return ans;
    }
}