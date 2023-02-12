class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long cVal = 0;
        int N = nums.length;
        for(int i=0; i< N/2; i++){
            cVal += count(nums[i], nums[N-i-1]);
        }
        if(N%2==1){
            cVal += nums[N/2];
        }
        return cVal;
    }
    
    public int count(int n1, int n2){
        int res = n2;
        int d = 0;
        while(n2 != 0){
            n2 = n2/10;
            d++;
        }
        int t = n1;
        while(d!=0){
            t = t * 10;
            d--;
        }
        // System.out.println(res+t);
        return res + t;
    }
}