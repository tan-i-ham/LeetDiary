// naive solution: 2 for loops
// improve: use a map to record the (target - nums[i])'s and index
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // key is the counterpart, value is the idx
        for(int i=0; i< N; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}