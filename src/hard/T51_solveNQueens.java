package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51_solveNQueens {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        backTracking(n, 0, chessBoard);
        return result;
    }

    public void backTracking(int n, int row, char[][] chessBoard) {
        if (row == n) {
            result.add(array2List(chessBoard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, chessBoard, n)) {
                chessBoard[row][col] = 'Q';
                backTracking(n, row + 1, chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }

    public boolean isValid(int row, int col, char[][] chessBoard, int n) {
        // 注意无需检查行，因为每次只会取出一个放在一行上，因此一行一定只有一个皇后

        // 1.检查该列是否存在Q
        for (char[] chars : chessBoard) {
            if (chars[col] == 'Q') {
                return false;
            }
        }

        // 2.检查该45°对角线是否存在Q，注意不需要检查row+1那部分，因为下一层还没放，因此只需要检验左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // 3.检查135°对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard.length; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> array2List(char[][] chessBoard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessBoard) {
            list.add(new String(c));
        }
        return list;
    }
}
