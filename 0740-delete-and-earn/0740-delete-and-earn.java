class Solution {
    Map<Integer, Integer> points;
    Map<Integer, Integer> memo;
    public int deleteAndEarn(int[] nums) {
        memo = new HashMap<>();
        points = new HashMap<>();
        int max = 0;
        for(int num: nums){
            int ogSum = points.getOrDefault(num, 0);
            points.put(num, ogSum + num);
            max = Math.max(max, num);
        }
        
        return helper(max);
    }
    
    public int helper(int num){
        if(num==0){
            return 0;
        }
        if(num==1){
            return points.getOrDefault(num,0);
        }
        if(memo.containsKey(num)){
            return memo.get(num);
        }
        if(!points.containsKey(num)){
            return helper(num-1);
        }
        // take nums[idx]
        int take = points.get(num) + helper(num-2);
        
        // not take
        int notTake = helper(num-1);
        int res = Math.max(take, notTake);
        memo.put(num, res);
        return res;
    }
}

// TC: O(N + max(nums)) every time we have choices to take nums[idx] or not
// SC: O(N + max(nums))
