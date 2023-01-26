// buy[i]; the max profit when buy stock on i-th day
// sell[i]; the max profit when sell stock on i-th day
// buy[i] = sell[i-2] - prices[i], why i-2? because cooldown
// sell[i] = buy[i-1] + prices[i]
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[] buy = new int[N];
        int[] sell = new int[N];
        if(N==1){
            return 0;
        }
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]); // not buy on day 0
        sell[0] = 0;
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        int ans = sell[1];
        for(int i=2; i< N; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]); // (not buy, buy)
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            ans = Math.max(ans, sell[i]);
        }
        return sell[N-1];
    }
}
// b=[-1,-1,-1,1,1]
// s=[0,  1, 2,2,3]