class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(s, t, 0, 0);
    }
    public int dfs(String s, String t, int i, int j){
        if(i == s.length() || j== t.length()){
            return j < t.length()? 0: 1;
        }
        if(memo[i][j] !=-1){
            return memo[i][j];
        }
        int res = 0;
        if(s.charAt(i) == t.charAt(j)){
            res =  dfs(s, t, i+1, j+1) + dfs(s, t, i+1, j);
        }else{
            res = dfs(s, t, i+1, j);
        }
        
        memo[i][j] = res;
        return res;
    }
}

// dfs(0,0)
//     dfs(1,1)
//         dfs(2,2)
//             dfs(3,3) -> 1
//                 dfs(4,4) -> 1
//                     dfs(5,4) -> 1
//                         dfs(6,5) -> 1
//                             dfs(7,6) -> 1
//                             dfs(7,5) -> 0
//                         dfs(6,4) -> 0
//                             dfs(7,4) -> 0
//             dfs(3,2) -> 2
//                 dfs(4,3) -> 1
//                     dfs(5,4) -> 1
//                     dfs(5,3) -> 0
//                 dfs(3,3) -> 1
//         dfs(2,1)
//             dfs(3,2)
//     dfs(1,0)