// no duplicate and order does not matter
// map, key is 0-n1-n2, value is list of set {[n1,n2]}
// TC: O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i< N; i++){
            if(i==0 || nums[i] != nums[i-1]){
                int l = i+1;
                int r = N - 1;
                
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum < 0){
                        l++;
                    }else if(sum > 0){
                        r--;
                    }else{
                        ans.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                        while (l < r && nums[l] == nums[l - 1]){
                            l++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
