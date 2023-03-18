class Solution {
    public int tribonacci(int n) {
        if(n==0 || n==1){
            return n;
        }
        int threePrev = 0;
        int twoPrev = 1;
        int prev = 1;
        int curr = prev;
        for(int i=3; i<=n; i++){
            curr = prev + twoPrev + threePrev;
            threePrev = twoPrev;
            twoPrev = prev;
            prev = curr;
        }
        return curr;
    }
}