class Solution {
    public int maxArea(int[] h) {
        int N = h.length;
        int l = 0;
        int r = N-1;
        int max = 0;
        while(l < r){
            int currH = Math.min(h[l], h[r]);
            max = Math.max(max, currH * (r-l));
            if(h[l] <= h[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}