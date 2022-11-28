class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] maxLeft = new int[N]; // exclude itself
        int[] maxRight = new int[N];// exclude itself
        
        for(int i=1; i< N; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for(int i=N-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }        
        int ans = 0;
        for(int i=0; i< N; i++){
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(water > 0){
                ans += water;
            }
        }
        return ans;
    }
}