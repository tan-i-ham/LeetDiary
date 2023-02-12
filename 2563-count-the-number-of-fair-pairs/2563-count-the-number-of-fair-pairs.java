class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        int N = nums.length;
        Arrays.sort(nums);
        long r1 = 0;
        for(int i=0, j=N-1; i< j; i++){
            while(i < j && nums[i]+nums[j] > upper){
                j--;
            }
            r1 += j - i;
        }
        long r2 = 0;
        for(int i=0, j=N-1; i< j; i++){
            while(i < j && nums[i]+nums[j] > lower - 1){
                j--;
            }
            r2 += j - i;
        }
        
        return r1 - r2;
    }
}