class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board.length == 0) return;
        int output[][] = new int[board.length][];
        
        for(int i=0; i<board.length; i++){
            output[i] = new int[board[i].length];
            for(int j=0; j<board[i].length; j++){
                output[i][j] = neighbors(board, i, j);
                // System.out.println(i+" "+j +" -> "+output[i][j]);
            }
        }
        for(int k=0; k<output.length; k++){
            board[k] = output[k].clone();
        }
    }
    public int neighbors(int board[][], int i, int j){
        int ones = 0;
                // check all neighbors and rules and boundaries
                if(i-1 >= 0 && j-1>= 0 && board[i-1][j-1] == 1)
                    ones++;
                if(i-1 >= 0 && j>= 0 && board[i-1][j] == 1)
                    ones++;
                if(i-1 >= 0 && j+1<board[i-1].length && board[i-1][j+1] == 1)
                    ones++;
                if(i >= 0 && j-1>= 0 && board[i][j-1] == 1)
                    ones++;
                // skip self
                if(i >= 0 && j+1 < board[i].length && board[i][j+1] == 1)
                    ones++;
                if(i+1 <board.length && j-1>= 0 && board[i+1][j-1] == 1)
                    ones++;
                if(i+1 <board.length && j>= 0 && board[i+1][j] == 1)
                    ones++;
                if(i+1 <board.length && j+1<board[i+1].length && board[i+1][j+1] == 1)
                    ones++;
        
        
        int result = board[i][j];
        
        // Apply rules
        if(board[i][j] == 1 && ones < 2) result = 0;
        else if(board[i][j] == 1 && (ones == 2 || ones == 3)) result = 1;
        else if(board[i][j] == 1 && ones > 3) result = 0;
        else if(board[i][j] == 0 && ones  == 3) result = 1;
        
        return result;
    }
}