class Solution {
    boolean[][] canDrop;
    public int[][] candyCrush(int[][] board) {
        while(canCrush(board)){
            board = drop(board);
        }
        return board;
    }
    
    public boolean canCrush(int[][] board){
        int rLen = board.length;
        int cLen = board[0].length;
        canDrop = new boolean[rLen][cLen];
        boolean shoudDrop = false;
        // row
        for(int c=0; c< cLen; c++){
            for(int r=0; r< rLen-2; r++){
                if(board[r][c]==0){
                    continue;
                }
                if(board[r][c] == board[r+1][c]
                    && board[r+1][c] == board[r+2][c]){
                    shoudDrop = true;
                    int rowIdx = r;
                    int val = board[rowIdx][c];
                    while(rowIdx < rLen &&  board[rowIdx][c] == val){
                        canDrop[rowIdx++][c] = true;
                    }
                }

            }    
        }
        
        // col
        for(int r=0; r< rLen; r++){
            for(int c=0; c< cLen-2; c++){
                if(board[r][c]==0){
                    continue;
                }                
                if(board[r][c] == board[r][c+1]
                    && board[r][c+1] == board[r][c+2]){
                    shoudDrop = true;
                    int colIdx = c;
                    int val = board[r][colIdx];
                    while(colIdx < cLen &&  board[r][colIdx] == val){
                        canDrop[r][colIdx++] = true;
                    }
                }
            }    
        }     
        return shoudDrop;
    }
    
    public int[][] drop(int[][] board){
        int rLen = board.length;
        int cLen = board[0].length;        
       for(int c=0; c< cLen; c++){       
           
            int replaceEnd = rLen-1;
            for(int r=rLen-1; r >=0; r--){
                if(!canDrop[r][c]){
                    board[replaceEnd--][c] = board[r][c];
                }
            }

            for(int r=replaceEnd ; r >=0; r--){
                board[r][c] = 0;
            }
        }
        // for(int r=rLen-1; r>=0; r--){
        //     System.out.println(Arrays.toString(canDrop[r]));
        // }
        return board;
    }
}