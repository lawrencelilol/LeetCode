public class Sudoku {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    continue;
                }
                for (char k = '0'; k <= '9'; k++) {
                    if(isValidSudoku(i,j,k,board)) {
                        board[i][j] = k;
                        if(solveSudokuHelper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(int row, int col, char val, char[][] board) {
        // check if there is a repeat value in the same row
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == val) {
                return false;
            }
        }

        // check if there is a repeat value in the same coloum
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == val) {
                return false;
            }
        }

        // check if there is a repeat in the same nine squares
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
