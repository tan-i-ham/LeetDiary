class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new LinkedList<>();
        int N = num.length;
        long x = 0;
        for(int i=N-1; i >=0; i--){
            int digit = (num[i] + k) %10;
            ans.add(0, digit);
            k = (num[i] + k)/10;
        }

        while(k > 0){
            ans.add(0, k%10);
            k = k /10;
        }

     
        return ans;
    }
}