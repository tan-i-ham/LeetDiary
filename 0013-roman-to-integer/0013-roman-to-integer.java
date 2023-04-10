class Solution {
    public int romanToInt(String s) {
        int N = s.length();
        int ans = 0;
        for(int i=0; i< N; i++){
            char ch = s.charAt(i);
            
            if(ch == 'I'){
                if(i+1 < N){
                    char next = s.charAt(i+1);
                    if(next == 'V'){
                        ans += 4;
                         i++;
                    }else if(next == 'X'){
                        ans += 9;
                        i++;
                    }else{
                        ans += 1;
                    }
                }else{
                    ans += 1;
                }                  
            }else if(ch == 'V'){
                ans += 5;
            }else if(ch == 'X'){
                if(i+1 < N){
                    char next = s.charAt(i+1);
                    if(next == 'L'){
                        ans += 40;
                         i++;
                    }else if(next == 'C'){
                        ans += 90;
                        i++;
                    }else{
                        ans += 10;
                    }
                }else{
                    ans += 10;
                }                
            }else if(ch == 'L'){
                ans += 50;
            }else if(ch == 'C'){
                if(i+1 < N){
                    char next = s.charAt(i+1);
                    if(next == 'D'){
                        ans += 400;
                         i++;
                    }else if(next == 'M'){
                        ans += 900;
                        i++;
                    }else{
                        ans += 100;
                    }
                }else{
                    ans += 100;
                }
            }else if(ch == 'D'){
                ans += 500;
            }else if(ch == 'M'){
                ans += 1000;
            }
        }
        return ans;
    }
}