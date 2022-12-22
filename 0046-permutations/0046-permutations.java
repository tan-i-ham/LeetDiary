class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int num: nums){
            list.add(num);
        }
        
        return dfs(list);
    }
    
    public List<List<Integer>> dfs(List<Integer> list){
        List<List<Integer>> res = new ArrayList<>();
        if(list.size() == 1){
            res.add(new ArrayList<>(list));
            return res;
        }
        int N = list.size();
        for(int i=0; i< N; i++){
            int popNum = list.get(0);
            list.remove(0);
            
            List<List<Integer>> perms = dfs(list);
            
            for(List<Integer> perm: perms){
                perm.add(popNum);
                res.add(new ArrayList<>(perm));
            }
            list.add(popNum);
        }
        return res;
    }
}
// TC: O(N!)
// SC: O(N)