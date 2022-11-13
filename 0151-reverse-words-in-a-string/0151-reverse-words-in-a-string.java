class Solution {
    public String reverseWords(String s) {
        boolean isStart = false;

        StringBuilder builder = new StringBuilder();
        int left = 0, right = s.length() - 1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ') ++left;

        // remove trailing spaces
        while (left <= right && s.charAt(right) == ' ') --right;
        s = s.substring(left, right+1);

        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(!isStart && ch==' '){
                continue;
            }else{
                isStart = true;
                if(ch == ' ' && ch == s.charAt(i-1)){
                    continue;
                }
                builder.append(ch);
            }
        }
        // String temp = builder.toString();
        int len = builder.length();
        if(builder.charAt(len-1) == ' '){
            builder.deleteCharAt(len-1);
        }
        
        for(int i=0; i< builder.length(); i++){
            // System.out.println(i);
            int idx = builder.indexOf(" ", i);
            // System.out.println(idx);
            int l = i;
            
            int r = idx-1;
            if(idx<0){
                r = builder.length()-1;
            }
            while (l < r) {
              char tmp = builder.charAt(l);
              builder.setCharAt(l++, builder.charAt(r));
              builder.setCharAt(r--, tmp);
            }
            if(idx<0){
                break;
            }
            i = idx;
        }
        
        return builder.toString();
    }
    
  
}