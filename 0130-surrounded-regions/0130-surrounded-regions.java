// base:
// 
// visit from border and is 'O' , find neighor is 'O' to do the dfs
class Solution {
    boolean[][] v;
    public void solve(char[][] board) {
        int rLen = board.length;
        int cLen = board[0].length;
        v = new boolean[rLen][cLen];
        
        for(int r=0; r< rLen; r++){
            for(int c=0; c< cLen; c++){
                if(!v[r][c] && board[r][c]=='O' && 
                   (r==0 || r == rLen-1 || c==0 || c == cLen-1) ){
                    dfs(board, r, c);
                }
            }
        }
        for(int r=0; r< rLen; r++){
            for(int c=0; c< cLen; c++){
                if(!v[r][c] && board[r][c]=='O'){
                    board[r][c] = 'X';
                }
            }
        }      
    }
    public void dfs(char[][] board, int r, int c){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length){
            return;
        }
        
        if(!v[r][c] && board[r][c]=='O'){
            v[r][c] = true;    
            dfs(board, r+1, c);
            dfs(board, r-1, c);
            dfs(board, r, c+1);
            dfs(board, r, c-1);
        }
        

    }
}