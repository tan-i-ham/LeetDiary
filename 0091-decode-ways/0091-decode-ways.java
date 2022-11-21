// h(s, 0)
// single char -> if "1", "2", ... "9", one way
// two chars -> first char is "1"  and second char is "0", "2".... "9", one way
// two chars -> first char is "2"  and second char is "0", "2".... "6", one way
class Solution {
    Map<String, Integer> map;
    public int numDecodings(String s) { 
        map = new HashMap<>();
        map.put("", 1);
        map.put("0", 0);
        return helper(s);
    }
    public int helper(String s) {
        int sLen = s.length();
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(sLen==0){
            return 1;
        }
        if(sLen==1){
            if(s.charAt(0) == '0'){
                return 0;
            }
            map.put(s, 1);
            return 1;
        }
        int res = 0;
        if(s.charAt(0) >= '1' && s.charAt(0) <= '9'){
            res += helper(s.substring(1));
        }
        if(s.charAt(0)=='1'){
             if(sLen>=2 && s.charAt(1) >= '0' && s.charAt(1) <= '9'){
                res += helper(s.substring(2));
            }
        }
        if(s.charAt(0)=='2'){
             if(sLen>=2 && s.charAt(1) >= '0' && s.charAt(1) <= '6'){
                res += helper(s.substring(2));
            }
        }        
        map.put(s, res);
        return res;
    }
    
}
// TC: O(2^N)
// SC: O(N), N is the len(s)