// backtrack, base case, 0 return 1
// n=45, TLE
// use map to store the counted value, e.g. key is n, value is the ways to climb to the top
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
   
    public int climbStairs(int n) {
         
        if(n<0){
            return 0;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n==0){
            map.put(0,1);
            return 1;
        }
        // choose either climb 1 step or 2 steps
        int ans = climbStairs(n-1) + climbStairs(n-2);
        map.put(n, ans);
        return ans;
    }
}