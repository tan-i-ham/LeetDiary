
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> idxByCh = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(idxByCh.containsKey(ch)){
                left = Math.max(idxByCh.get(ch), left);
            }
            max = Math.max(max, right-left+1);
            idxByCh.put(ch, ++right); 
        }
        
        return max;
    }
}

