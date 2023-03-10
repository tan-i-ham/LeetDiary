class Solution {
    int[][] memo;
    int s1Len;
    int s2Len;
    int s3Len;
    public boolean isInterleave(String s1, String s2, String s3) {
        s1Len = s1.length();
        s2Len = s2.length();
        s3Len = s3.length();
        
        memo = new int[s1Len][s2Len];
        if(s1Len + s2Len != s3Len){
            return false;
        }
        for (int i = 0; i < s1Len; i++) {
            for (int j = 0; j < s2Len; j++) {
                memo[i][j] = -1;
            }
        }
        return backtrack(s1,s2,s3,0,0);
    }
    public boolean backtrack(String s1, String s2, String s3, int i1, int i2){
        if(i1 == s1Len){
            return s2.substring(i2).equals(s3.substring(i1+i2));
        }
        if(i2 == s2Len){
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