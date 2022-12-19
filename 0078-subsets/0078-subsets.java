class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    
    public void dfs(int[] nums, int startIdx, List<Integer> curr){
        ans.add(new ArrayList<>(curr));
        
        for(int i=startIdx; i< nums.length; i++){
            curr.add(nums[i]);
            dfs(nums, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}