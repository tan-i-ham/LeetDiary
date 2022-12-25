class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        dfs(n, k, new ArrayList<>(), 1);
        return ans;
    }
    public void dfs(int n, int k, List<Integer> currCom, int startIdx){
        if(currCom.size() == k){
            ans.add(new ArrayList<>(currCom));
            return;
        }
        
        for(int i=startIdx; i<= n; i++){
            currCom.add(i);
            dfs(n, k, currCom, i+1);
            currCom.remove(currCom.size()-1);
        }
    }
}