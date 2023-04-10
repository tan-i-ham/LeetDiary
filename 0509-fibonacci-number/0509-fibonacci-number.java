class Solution {
    int[] memo = new int[31];
    public int fib(int n) {
        if(n==0 || n==1){
            memo[n] = n; 
            return n;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n] = fib(n-2) + fib(n-1);
        return memo[n];
    }
}

// TC: O(N)
// SC: O(N), method call stack