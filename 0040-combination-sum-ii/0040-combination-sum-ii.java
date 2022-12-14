class Solution {

    List<List<Integer>> ans;
    int N;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        N = candidates.length;
        Arrays.sort(candidates);

        dfs(candidates, target, new ArrayList<>(), 0);
        
        return ans;
    }
    public void dfs(int[] candidates, int target, List<Integer> currCom, int startIdx){
        if(target == 0){
            ans.add(new ArrayList<>(currCom));
            return;
        }
        for(int i=startIdx; i< N; i++){
            if(candidates[i] > target){
                break;
            }
            if(i > startIdx && candidates[i] == candidates[i-1]){
                continue;
            }

            currCom.add(candidates[i]);
            dfs(candidates, target - candidates[i], currCom, i+1);
            currCom.remove(currCom.size()-1);
        }
    }
}
// TC: O(2^N)
// SC: O(N)