class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new int[s1.length()][s2.length()];
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return backtrack(s1,s2,s3,0,0);
    }
    public boolean backtrack(String s1, String s2, String s3, int i1, int i2){
        if(i1 == s1.length()){
            return s2.substring(i2).equals(s3.substring(i1+i2));
        }
        if(i2 == s2.length()){
            return s1.substring(i1).equals(s3.substring(i1+i2));
        }  
        
        if(memo[i1][i2] >= 0){
            return memo[i1][i2] == 1 ? true: false;
        }
        
        if(s1.charAt(i1) == s3.charAt(i1+i2)){
            if(backtrack(s1,s2,s3,i1+1, i2)){ // continue choose s1
                memo[i1][i2] = 1;
                return true;
            } 
        }

        if(s2.charAt(i2) == s3.charAt(i1+i2)){
            if(backtrack(s1,s2,s3,i1, i2+1)){ // continue choose s2
                memo[i1][i2] = 1;
                return true;
            }
        }  
        
        memo[i1][i2] = 0;
        return false;
    }
}