class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = 0;
        for(int pile: piles){
            maxK = Math.max(maxK, pile);
        }
        int l = 1;
        int r = maxK;
        while(l < r){
            int speed = l + (r - l)/2;
            int currHour = 0;
            for(int p: piles){
                currHour += Math.ceil((double) p/speed);
            }
            if(currHour <= h){
                r = speed;
            }else{
                l = speed + 1;
            }
        }
        return l;
    }
}