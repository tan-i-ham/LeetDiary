class Solution {
    public int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        int twoPrev = 0;
        int prev = 1;
        int curr = 0;
        for(int i=2; i<=n; i++){
            curr = prev + twoPrev;
            twoPrev = prev;
            prev = curr;
        }
        return curr;
    }
}