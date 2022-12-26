class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int N = temperatures.length;
        int[] ans = new int[N];
        for(int i=0; i< N; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[1] < t){
                int[] curr = stack.pop();
                ans[curr[0]] = i -curr[0];
            }
            stack.push(new int[]{i, t});
        }
        return ans;
    }
}

// TC: O(N)
// SC: O(N)