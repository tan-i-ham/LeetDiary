// i== currMaxRangeTo, when iterate to currMaxRangeTo, 
// this means, we reach to the furthest idx in current step/jump (1),
// we need to increase a step/jump (1->2), and update the latest idx we can reach for next jump (2)
class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        if(N==1){
            return 0;
        }
        int currMaxRangeTo = 0;
        int nextMaxRangeTo = 0;
        int jumps = 0;
        for(int i=0; i < N; i++){
            nextMaxRangeTo = Math.max(nextMaxRangeTo, i + nums[i]);
            if(i==currMaxRangeTo){
			    if (currMaxRangeTo >= N - 1) {
					break;
                }                
                currMaxRangeTo = nextMaxRangeTo;
                jumps++;
            }
        }
        return jumps;
    }
}