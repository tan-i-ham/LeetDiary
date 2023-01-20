// TC: O(n^2)
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        ans = new ArrayList<>();
        
        
        for(int i=0; i< N; i++){
            if(i> 0 && nums[i]==nums[i-1]){ // choose a, to avoid duplicate triplets
                continue;
            }
            if(nums[i] > 0){
                break; // because array is sorted, the remaining value after index i, the sum cannot be 0
            }
            twoSum(-nums[i], i+1, nums);
        }
        return ans;
    }
    
    public void twoSum(int target, int startFrom, int[] nums){
        Set<Integer> seen = new HashSet<>();
        
        for(int i=startFrom; i< nums.length; i++){
            int complement = target - nums[i];
            if(seen.contains(complement)){
                ans.add(Arrays.asList(nums[startFrom-1], nums[i], complement));
                while(i + 1 < nums.length && nums[i] == nums[i+1]){
                    i++;
                }
            }
            seen.add(nums[i]);
        }
    }
}

// TC: O(N^2)
// SC: O(N) , the seen set
