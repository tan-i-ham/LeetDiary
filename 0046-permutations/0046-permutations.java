class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, new ArrayList<>());
        return ans;
    }
    
    public void dfs(int[] nums, List<Integer> currPer){
        if(nums.length == currPer.size()){
            ans.add(new ArrayList<>(currPer));
            return;
        }
        
        for(int num: nums){
            if(currPer.contains(num)){
                continue;
            }
            currPer.add(num);
            dfs(nums, currPer);
            currPer.remove(currPer.size()-1);
        }
    }
}
// TC: O(2^N)
// SC: O(N)