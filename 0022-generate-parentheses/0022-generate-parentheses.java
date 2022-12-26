class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder());
        return ans;
    }
    public void backtrack(int n, int open, int close, StringBuilder sb){
        if(sb.length() == n*2){
            ans.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append('(');
            backtrack(n, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(close < open){
            sb.append(')');
            backtrack(n, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
// (, 1, 0
//     ((, 2, 0
//         (((, 3, 0
//            (((), 3, 1
//              ((()), 3, 2
//                 ((())), 3, 3 -> add
//         ((), 2, 1
//            (()(, 3, 1
//               (()(), 3, 2
//                 (()()), 3, 3 -> add
//            (()), 2, 2
//               (())(, 3, 2
//                 (())(), 3, 3 -> add
//     (), 1, 1            
//         ()(, 2, 1
//            ()((, 3, 1
//              ()((), 3, 2
//                 ()(()), 3, 3 -> add
//            ()(), 2, 2
//               ()()(, 3, 2
//                 ()()(), 3, 3 -> add