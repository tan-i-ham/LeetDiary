// create a variable stands for the buy price 
class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int ans = 0;
        
        for(int i=1; i< prices.length; i++){
            ans = Math.max(ans, prices[i] - buy);
            if(prices[i] < buy){
                buy = prices[i];
            }
        }
        return ans;
    }
}
// TC: O(N)
// SC: O(1)