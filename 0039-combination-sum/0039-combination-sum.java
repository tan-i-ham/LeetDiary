class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>());
        return ans;
    }
    
    public void backtrack(int startIdx, int[] candidates, int target, List<Integer> curr){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i=startIdx; i< candidates.length; i++){
            if(candidates[i] > target){
                continue;
            }
            curr.add(candidates[i]);
            backtrack(i, candidates, target-candidates[i], curr);
            curr.remove(curr.size()-1);
        }
    }
}