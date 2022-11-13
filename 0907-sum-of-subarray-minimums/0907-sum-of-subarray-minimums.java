class Solution {
    int MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        Stack<Integer> stack = new Stack<>(); // index
        long ans = 0;
        for(int i=0; i<= N; i++){
            while(!stack.isEmpty() && (i== N || arr[i] <= arr[stack.peek()]) ){
                int mid = stack.pop();
                int prevSmallerIdx = stack.isEmpty() ? -1 : stack.peek();
                int nextSmallerIdx = i;
                long count = (mid - prevSmallerIdx) * (nextSmallerIdx - mid) % MOD;
                ans += (count * arr[mid]) % MOD;
                ans %= MOD;
                
            }
            stack.push(i);
        }
        return (int)ans;
    }
}