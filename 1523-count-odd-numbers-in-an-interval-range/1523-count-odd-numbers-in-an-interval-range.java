class Solution {
    public int countOdds(int low, int high) {
        int more = high/2;
        int less = low/2;
        if(high%2==1){
            return more-less + 1;
        }
        return more-less;
    }
}