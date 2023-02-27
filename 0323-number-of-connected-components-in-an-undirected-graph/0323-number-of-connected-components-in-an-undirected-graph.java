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
        
        public int find(int vertex){
            if(vertex == root[vertex]){
                return vertex;
            }
            return root[vertex] = find(root[vertex]);
        }
        
        public int union(int v1, int v2){
            int r1 = find(v1);
            int r2 = find(v2);
            if(r1 == r2){
                return 0;
            }
            if(r1 != r2){
                if(rank[r1] > rank[r2]){
                    root[r2] = r1;
                }else if(rank[r2] > rank[r1]){
                    root[r1] = r2;
                }else{
                    root[r1] = r2;
                    rank[r1]++;
                }
            }
            return 1;
        }
        
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int components = n;
        for(int[] e: edges){
            components -= uf.union(e[0], e[1]);
        }

        return components;
    }
}