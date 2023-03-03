class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        for(int i=0; i<= hLen - nLen; i++){
            String subStr = haystack.substring(i, i+nLen);
            if(subStr.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

// TC: O(N)
// SC: O(1)