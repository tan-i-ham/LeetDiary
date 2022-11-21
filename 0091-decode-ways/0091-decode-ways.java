// h(s, 0)
// single char -> if "1", "2", ... "9", one way
// two chars -> first char is "1"  and second char is "0", "2".... "9", one way
// two chars -> first char is "2"  and second char is "0", "2".... "6", one way
class Solution {
    Map<String, Integer> map;
    public int numDecodings(String s) { 
        int sLen = s.length();
        if(sLen==0){
            return 0;
        }
        int[] dp = new int[sLen+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0' ? 0 :1;
        
        
        for(int i=2; i<= sLen; i++){
            char prevTwoChar = s.charAt(i-2);
            char prevOneChar = s.charAt(i-1);
            if(prevOneChar != '0'){
                dp[i] = dp[i-1];    
            }
    
            if(prevTwoChar == '1' && prevOneChar>='0' && prevOneChar<='9'){
                dp[i] += dp[i-2];
            }
            if(prevTwoChar == '2' && prevOneChar>='0' && prevOneChar<='6'){
                dp[i] += dp[i-2];
            }
        }
        
        return dp[sLen];
    }
}
// TC: O(N)
// SC: O(N), N is the len(s)