class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, int startIdx, List<Integer> curr){
        ans.add(new ArrayList<>(curr));
        
        for(int i=startIdx; i< nums.length; i++){
            if(i > startIdx && nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            dfs(nums, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}