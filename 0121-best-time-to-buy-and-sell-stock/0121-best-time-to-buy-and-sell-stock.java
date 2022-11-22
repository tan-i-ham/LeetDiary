// assign two 
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int L = 0;
        int R = 1;
        int maxProfit = 0;
        while(L < R && L < N & R < N){
            int currProfit = prices[R] - prices[L];
            if(currProfit < 0){
                L++;
            }else{
                maxProfit = Math.max(currProfit, maxProfit);
                R++;
            }
            if(L==R){
                R++;
            }
        }
        return maxProfit;
    }
}
// L   R   max
// 0   1   0
// 1   2   4
// 1   3   4
// 1   4   5
// 1   5   5