import java.util.HashSet;

public class Leet_validSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!seen.add("Seen " + ch + " at row " + i) || !seen.add("Seen " + ch + " at column " + j)
                            || !seen.add("Seen " + ch + " at box " + i / 3 + "" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }
}