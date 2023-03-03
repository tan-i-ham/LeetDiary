//  know the length of string -> N
// is whole string count? e.g. "abc" should return true? should return false
//  for substring window size 1 to N/2
//      if the part has the same substring, if yes continue, no then break
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int sLen = s.length();
        boolean isFound = true;
        for(int winSize=1; winSize<= sLen/2; winSize++){
            if(sLen % winSize != 0){
                continue;
            }
            String substr = s.substring(0, winSize);
            // System.out.println(substr);
            for(int i=winSize; i<= sLen - winSize; i+=winSize){
                if(!substr.equals(s.substring(i, i+winSize)) ){
                    isFound = false;
                    break;
                }
            }
            if(isFound){
                return true;
            }
            isFound = true;
        }
        return false;
    }
}