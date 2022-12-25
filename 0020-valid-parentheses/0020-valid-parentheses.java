class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.add(')');
            }else if(ch == '{'){
                stack.add('}');
            }else if(ch == '['){
                stack.add(']');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char c = stack.pop();
                if(c!= ch){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}