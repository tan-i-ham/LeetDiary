// TC: O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        
        // a + b + c = 0
        
        for(int i=0; i< N; i++){
            if(i> 0 && nums[i]==nums[i-1]){ // choose a
                continue;
            }
            int l = i+1;
            int r = N-1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < 0){
                    l++;
                }else if(sum > 0){
                    r--;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while(l< r && nums[l] == nums[l-1]){ // increase the left pointer only, because the array is sorted, right point will be updated at line 24, e.g [-3,-2,-2,0,0,2,2], l will to first 0, the r will start to decrease
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
