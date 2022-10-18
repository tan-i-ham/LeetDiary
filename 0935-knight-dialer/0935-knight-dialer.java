// create a map that key is the curr pos, the value is a list of possible next pos
// e.g. { 1: [6.8], 2:[7,9] ... } 2 way: 7 num, 3 way 2 num

class Solution {
    Map<Integer, int[]> map;
    
    final static long fixMod = 1000000007;
    public int knightDialer(int n) {
        if(n==1){
            return 10; // 5 only appear in this case
        }
        
        map = new HashMap<>();
        map.put(1, new int[]{6,8});
        map.put(2, new int[]{7,9});
        map.put(3, new int[]{4,8});
        map.put(4, new int[]{0,3,9});
        map.put(6, new int[]{0,1,7});
        map.put(7, new int[]{2,6});
        map.put(8, new int[]{1,3});
        map.put(9, new int[]{2,4});
        map.put(0, new int[]{4,6});

    
        long[][] dp = new long[10][n+1]; // dp[i][j]: the combinations in step j when that step's dial number is i 
        long ans = 0;

        for(int step=1; step<=n; step++){
            for(int i=0; i<=9; i++){
                dp[i][1] = 1;  // in step, itself, only one way
                for(int neighor: neighors(i)){
                    dp[i][step] =  (dp[i][step] + dp[neighor][step-1] % fixMod)% fixMod;
                }
                // dp[i][step] %= fixMod;
            }
        }
        for(int i=0; i<=9; i++){
            ans = (ans + (dp[i][n]% fixMod))% fixMod;
        }
        return (int) ans;
    }


    public int[] neighors(int num){
        if(num==5){
            return new int[]{};
        }
        return map.get(num);
    }
}

// h(6,2)
//     h(0,1)
//     h(1,1)
//     h(7,1)