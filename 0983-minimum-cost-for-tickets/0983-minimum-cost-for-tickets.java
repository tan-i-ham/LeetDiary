class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int N = days.length;
        // dp[i] means: the min cost from 1 to i
        int[] dp = new int[days[N-1]+1];
        Set<Integer> set = new HashSet<>();
        for(int d: days){
            set.add(d);
        }
        for(int i=1; i <= days[N-1]; i++){
            if(set.contains(i)){
                if(i-1 >= 0){
                    dp[i] = dp[i-1] + costs[0];
                }else{
                    dp[i] = dp[0] + costs[0];
                }
                if(i-7 >= 0){
                    dp[i] = Math.min(dp[i], dp[i-7] + costs[1]);
                }else{
                    dp[i] = Math.min(dp[i], dp[0] + costs[1]);
                }
                if(i-30 >= 0){
                    dp[i] = Math.min(dp[i], dp[i-30] + costs[2]);
                }else{
                    dp[i] =  Math.min(dp[i], dp[0] + costs[2]);
                }         
            }else{
                dp[i] = dp[i-1];
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[days[N-1]];
    }
}
// TC: O(max(days))
// SC: O(N) because set