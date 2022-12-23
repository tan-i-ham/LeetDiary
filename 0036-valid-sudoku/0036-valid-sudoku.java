class Solution {

    public boolean isValidSudoku(char[][] board) {
        int rLen = board.length;
        int cLen = board[0].length;
        boolean[][] rows = new boolean[rLen][cLen];
        boolean[][] cols = new boolean[rLen][cLen];
        boolean[][] boxs = new boolean[rLen][cLen];
        
        
        for(int r=0; r< rLen; r++){
            for(int c=0; c< cLen; c++){
                if(board[r][c] =='.'){
                    continue;
                }
                int val = board[r][c] - '1';
                int boxIdx = 3 * (r/3) + c/3;
                if(rows[r][val] || cols[c][val] || boxs[boxIdx][val]){
                    return false;
                }
                
                rows[r][val] = true;
                cols[c][val] = true;
                boxs[boxIdx][val] = true;
            }
        }
        return true;
    }
}