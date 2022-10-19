// s = "3[a2[c]]"
// '[' : push digit to countStack, push currStr to
// char: append to currStr          prevStrStack
// ']': pop
class Solution {
    public String decodeString(String s) {
        Stack<Integer> cStack = new Stack<>();
        Stack<String> sStack = new Stack<>();
        
        int digit = 0;
        String prevStr = "";
        String currStr = "";
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                digit = digit*10 + (ch -'0');
            }else if(ch == '['){
                cStack.push(digit);
                sStack.push(currStr);
                digit = 0;
                currStr = "";
            }else if(ch == ']'){
                prevStr = sStack.pop();
                int count = cStack.pop();
                String temp = "";
                while(count >0){
                    temp+=currStr;
                    count--;
                }
                currStr = prevStr + temp;
                // prevStr = currStr;
            }else{
                currStr+=ch;
            }
        }
        return currStr;
    }
}

// s = "3[a2[c]]"
// countStack  prevStrStack    prevStr currStr
// [3]         []              ""      ""
// [3]         [""]            ""      ""      
// [3]         [""]            ""      "a"
// [3,2]       ["a"]           ""      ""
// [3,2]       ["a"]           ""      "c"
// [3]         ["acc"]         "a"     "acc"->""    
// [3]         ["acc"]         "acc"     "acc"        
    
    