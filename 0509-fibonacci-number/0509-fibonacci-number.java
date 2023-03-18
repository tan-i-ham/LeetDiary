class Solution {
    int[] memo;
    public int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        memo = new int[n+1];
        memo[1] = 1;
        return helper(n);
    }
    public int helper(int n){
        if(n==0 || n==1){
            return n;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n] = helper(n-2) + helper(n-1);
        return memo[n];
    }
}