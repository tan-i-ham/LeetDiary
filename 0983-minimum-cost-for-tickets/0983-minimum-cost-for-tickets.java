class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int N = days.length;
        int[] memo = new int[N+1];
        return dfs(days, costs, 0, memo);
        // return memo[N];
    }
    public int dfs(int[] days, int[] costs, int idx, int[] memo){
        int N = days.length;
        if(idx >= N){
            return 0 ;
        }
        if(memo[idx]!=0){
            return memo[idx];
        }
        int dayCost = costs[0] + dfs(days, costs, idx+1, memo);
        
        int i=idx;
        while(i<N && days[i] < days[idx] + 7){
            i++;
        }
        int weekCost = costs[1] + dfs(days, costs, i, memo);
        
        i= idx;
        while(i<N && days[i] < days[idx]+30){
            i++;
        }
        int monthCost = costs[2] + dfs(days, costs, i, memo);
        
        int ans = Math.min(dayCost, weekCost);
        ans =  Math.min(ans, monthCost);
        memo[idx] = ans;
        return ans;
    }    
}