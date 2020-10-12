class Leet79_WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(hasWord(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    public boolean hasWord(char[][] board, int i, int j, String word, int index){
        if(index == word.length()) return true;
        if(i > board.length-1 || i < 0 || j > board[i].length-1 || j < 0 ||  board[i][j]!=word.charAt(index)) return false;
        board[i][j]='*';
        
        boolean result =
                    hasWord( board, i-1, j, word, index+1 ) ||
                    hasWord( board, i, j-1, word, index+1 ) ||                            
                    hasWord( board, i, j+1, word, index+1 ) ||
                    hasWord( board, i+1, j, word, index+1 );
        
        board[i][j]= word.charAt(index);
        return result;
    }
}
