class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 > l2){
            return false;
        }
        int[] count1 = new int[26];
        for(char c: s1.toCharArray()){
            count1[c - 'a']++;
        }
        
        int[] count2 = new int[26];
        int start = 0;
        for(int end=0; end < l2; end++){
            count2[s2.charAt(end) - 'a']++;
            if(end - start + 1 == l1){
                if(check(count1, count2)){
                    return true;
                }
                count2[s2.charAt(start) - 'a']--;  
                start++;
            }
        }
        return false;
    }
    public boolean check(int[] c1, int[] c2){
        for(int i=0; i< 26; i++){
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }
}

// TC: O(N_2 * 26)
// SC: O(26)