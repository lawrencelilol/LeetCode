import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for(char[] c : chessBoard) {
            Arrays.fill(c,'.');
        }
        queenHelper(n,0,chessBoard);
        return res;
    }

    public List<String> ArrayToList (char[][] chessBoard) {
        List<String> ans = new ArrayList<>();
        for (char[] c : chessBoard) {
            ans.add(String.copyValueOf(c));
        }
        return ans;
    }

    void queenHelper(int n , int row, char[][] chessBoard) {
        if(row == n) {
            res.add(ArrayToList(chessBoard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if(isValid(row, col, chessBoard, n)) {
                chessBoard[row][col] = 'Q';
                queenHelper(n,row + 1, chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }

    public boolean isValid(int row, int col,char[][] cheeseBoard, int n) {
        // check rows
        for (int i = 0; i < row; i++) {
            if(cheeseBoard[i][col] == 'Q') {
                return false;
            }
        }

        // check diagonal 45 degrees
        for (int i = row - 1, j = col -1; i >= 0 && j >= 0; i--,j--) {
            if(cheeseBoard[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--,j++) {
            if(cheeseBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
