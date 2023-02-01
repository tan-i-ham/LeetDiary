class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return dfs(s, p, 0, 0);
    }
    
    public boolean dfs(String s, String p, int i, int j){
        if(i>= s.length() && j>= p.length()){
            return true;
        }
        if(j>= p.length()){
            return false;
        }
        if(i< s.length() && memo[i][j] != null){
            return memo[i][j];
        }
        boolean firstMatch = i< s.length() &&
                            ( (s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.' );
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            // not use *
            boolean notUsed = dfs(s, p, i, j+2);
            boolean used = firstMatch && dfs(s, p, i+1, j);    
            memo[i][j] = notUsed || used;
            return memo[i][j];
        }
        memo[i][j] = firstMatch && dfs(s, p, i+1, j+1);   
        return memo[i][j];
    }
}

// TC: O(2^N)
// SC: O(N)