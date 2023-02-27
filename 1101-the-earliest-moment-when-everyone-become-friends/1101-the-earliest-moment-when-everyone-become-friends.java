// every person became acquainted with every other person -> every node is connected
class Solution {
    class UnionFind {
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
        
        public int find(int v){
            if(v == root[v]){
                return v;
            }
            return root[v] = find(root[v]);
        }
        
        public boolean union(int v1, int v2){
            int r1 = find(v1);
            int r2 = find(v2);
            if(r1 == r2){
                return false;
            }
            if(rank[r1] > rank[r2]){
                root[r2] = r1;
            }else if(rank[r1] < rank[r2]){
                root[r1] = r2;
            }else{
                root[r2] = r1;
                rank[r1]++;
            }
            return true;
        }
    }
    public int earliestAcq(int[][] logs, int n) {
        if(logs.length < n-1){
            return -1;
        }
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        UnionFind uf = new UnionFind(n);
        
        int groups = n;
        for(int[] log: logs){
            int timestamp = log[0];
            int f1 = log[1];
            int f2 = log[2];
            
            if(uf.union(f1, f2)){
                groups--;
            }
            
            if(groups == 1){
                return timestamp;
            }
        }
        return -1;
    }
}
// N is the length of logs array
// P is the number of people
// TC: O(NlogN)
// SC: O(N) + O(P)