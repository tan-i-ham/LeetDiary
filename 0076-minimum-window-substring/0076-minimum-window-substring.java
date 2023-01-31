// edge case: lenS < lenT, no such string
// 
class Solution {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        
        if(lenS < lenT){
            return "";
        }
        Map<Character, Integer> dictT = new HashMap<>();
        for(char c: t.toCharArray()){
            int ogCount = dictT.getOrDefault(c, 0);
            dictT.put(c, ogCount+1);
        }
        
        Map<Character, Integer> dictWin = new HashMap<>();
        
        int required = dictT.size();
        
        int l = 0;
        int formed = 0;
        int res = -1;
        int resR = lenT;
        int resL = 0;
        for(int r=0; r< lenS; r++){
            char ch = s.charAt(r);
            int ogCount = dictWin.getOrDefault(ch, 0);
            dictWin.put(ch, ogCount+1);
            
            if(dictT.containsKey(ch) &&
               dictWin.get(ch).equals(dictT.get(ch))
              ){
                formed++;
            }
            while(l <= r && formed == required){
                if(res == -1 || r - l + 1 < res){
                    res =  r - l + 1;
                    resL = l;
                    resR = r+1;
                }

                char lCh = s.charAt(l);
                dictWin.put(lCh, dictWin.get(lCh) - 1);
   
                if(dictT.containsKey(lCh) && dictWin.get(lCh) < dictT.get(lCh)){
                    formed--;
                }
                
                l++;
            }
        }
        if(res == -1){
            return "";
        }
        return s.substring(resL, resR);
    }
}

// TC: O(M+N)
// SC: O(M+N), M is the length of s