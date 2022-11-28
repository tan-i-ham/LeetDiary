class Solution {
    public boolean isPalindrome(String s) {   
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch-'a'>=0 && ch-'a' < 26){
                sb.append(ch);
            }else if(ch >= '0' && ch <= '9'){
                sb.append(ch);
            }
        }
        s = sb.toString();
        int N = s.length();
        int l = 0;
        int r = N-1;
        while(l<r){    
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}