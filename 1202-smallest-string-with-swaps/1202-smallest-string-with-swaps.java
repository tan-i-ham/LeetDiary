// if nodes is in the same set, then we can just sort the s
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int N = s.length();
        UnionFind uf = new UnionFind(N);
        for(List<Integer> l: pairs){
            uf.union(l.get(0), l.get(1));
        }
        
        Map<Integer, List<Integer>> groupByRoot = new HashMap<>();
        for(int i=0; i< N; i++){
            int r = uf.find(i);
            List<Integer> list = groupByRoot.getOrDefault(r, new ArrayList<>());
            list.add(i);
            groupByRoot.put(r, list);
        }
        
        char[] ans = new char[N];
        for(Integer root : groupByRoot.keySet()){
            List<Integer> group = groupByRoot.get(root); // group is sorted, cuz idx is added on order, L10-L15
            List<Character> chars = new ArrayList<>();
            for(int idx: group){
                chars.add(s.charAt(idx));
            }
            Collections.sort(chars);
            for(int i=0; i< group.size(); i++){
                ans[group.get(i)] = chars.get(i);
            }
        }
        return new String(ans);
    }
    
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
}