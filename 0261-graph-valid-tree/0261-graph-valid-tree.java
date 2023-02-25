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
            while(node != root[node]){
                node = root[node];
            }
            return node;
        }
        
        public boolean union(int n1, int n2){
            int r1 = find(n1);
            int r2 = find(n2);
            
            if(r1==r2){
                return false;
            }
            if(r1!=r2){
                if(rank[r1] > rank[r2]){
                    root[r2] = r1;
                }else if(rank[r1] < rank[r2]){
                    root[r1] = r2;
                }else{
                    root[r2] = r1;
                    rank[n1]++;
                }
            }
            return true;
        }
        
        public boolean isConnected(int n1, int n2){
            return find(n1) == find(n2);
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // if the graoh are all connected , the length of edge is N-1
        if(edges.length != n-1){
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }

        return true;
    }
}

// n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
// root = [0, 0, 0, 0, 0]
// rank = [2, 1, 1, 1, 1]

// n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
// root = [0, 0, 0, 0, 0]
// rank = [2, 1, 1, 1, 1]

// [[0,1],[0,2],[2,5],[3,4],[3,5]]
// root = [0, 0, 0, 3, 3, 3]
// rank = [2, 1, 1, 3, 1, 1]
