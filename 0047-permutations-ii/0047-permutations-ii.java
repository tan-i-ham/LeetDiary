class Solution {
    List<List<Integer>> ans;
    Map<Integer, Integer> counterMap;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        counterMap = new HashMap<>();

        for(int num: nums){
            int ogCount = counterMap.getOrDefault(num, 0);
            counterMap.put(num, ogCount+1);
        }
        dfs(nums, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, List<Integer> currPath){
        if(currPath.size() == nums.length){
            ans.add(new ArrayList<>(currPath));
            return;
        }
        Set<Integer> v = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry: counterMap.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(count==0){
                continue;
            }
            counterMap.put(num, count-1);
            currPath.add(num);
            dfs(nums, currPath);
            currPath.remove(currPath.size()-1);
            counterMap.put(num, count);
        }
    } 
}