// no duplicate and order does not matter
// map, key is 0-n1-n2, value is list of set {[n1,n2]}
// TC: O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        
        
        for(int i=0; i< N; i++){
            if(i> 0 && nums[i]==nums[i-1]){
                continue;
            }
            Set<Integer> seen = new HashSet<>();
            for(int j=i+1; j< N; j++){
                int sum = nums[i] + nums[j];
                if(seen.contains(-sum)){
                    ans.add(Arrays.asList(nums[i], nums[j], -sum));
                    while (j + 1 < N && nums[j] == nums[j + 1]){
                        j++;
                    }
                }
                seen.add(nums[j]);
            }
        }
        return ans;
    }
}
