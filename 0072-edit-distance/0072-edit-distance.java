
class Solution {
    Integer memo[][];
    int l1;
    int l2;
    public int minDistance(String word1, String word2) {
        l1 = word1.length();
        l2 = word2.length();
        memo = new Integer[l1+1][l2+1];
        return helper(word1, word2, l1, l2);
    }
    
    public int helper(String w1, String w2, int i1, int i2){
        if(i1 == 0){
            return i2;
        }
        if(i2 == 0){
            return i1;
        }
        
        if(memo[i1][i2] != null){
            return memo[i1][i2];
        }
        if(w1.charAt(i1-1) == w2.charAt(i2-1)){
            memo[i1][i2]  = helper(w1, w2, i1-1, i2-1);
            return memo[i1][i2];
        }
        // replace w1[i1]
        int rCount = helper(w1, w2, i1 - 1, i2 - 1) + 1; 
        // delete w1[i1]
        int dCount = helper(w1, w2, i1 - 1, i2) + 1;
        // insert w1[i2] at w1[i1-1]
        int iCount = helper(w1, w2, i1, i2 - 1) + 1;
        
        memo[i1][i2] = Math.min(iCount, Math.min(rCount,dCount));
        return memo[i1][i2];
    }
}

// h(0,0)
//     h(1,1)
//         h(2,2)
//     h(1,0)
//         h(2,1)
//             h(3,2)
//     h(0,1)
        