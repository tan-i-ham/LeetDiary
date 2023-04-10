class Solution {
    public boolean validPalindrome(String s) {
        int N = s.length();
        int l = 0;
        int r = N-1;
        
        while(l <= r && s.charAt(l)==s.charAt(r) ){
            l++;
            r--;
        }
        
        if(r <= l){
            return true;
        }
        int newL = l;
        int newR = r-1;
        
        // skip right char
        while(newL <= newR && s.charAt(newL)==s.charAt(newR)){
                newL++;
                newR--;
        }      
        if(newR <= newL){
            return true;
        }
    
        newL = l+1;
        newR = r;
        // skip left char
        while(newL <= newR && s.charAt(newL)==s.charAt(newR) ){
            newL++;
            newR--;
        }      
        if(newR <= newL){
            return true;
        }        
        return false;
    }
}