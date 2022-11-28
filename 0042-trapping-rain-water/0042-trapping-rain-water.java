class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int maxL = height[0];
        int maxR = height[N-1];
        int l = 0;
        int r = N-1;
        
        int ans = 0;
        while(l < r){
            if(height[l] <= height[r]){
                maxL = Math.max(maxL, height[l]);
                ans += maxL - height[l];
                l++;
            }else{
                maxR = Math.max(maxR, height[r]);
                ans  += maxR - height[r];
                r--;          
            }
        }
        return ans;
    }
}