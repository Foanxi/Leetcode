package hard;

public class T37_solveSudoku {
    public void solveSudoku(char[][] board) {
        backTracking(board);
    }

    public boolean backTracking(char[][] board) {
        // 负责遍历行
        for (int i = 0; i < board.length; i++) {
            // 负责遍历列
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char val = '1'; val <= '9'; val++) {
                    if (isValid(board, i, j, val)) {
                        board[i][j] = val;
                        if (backTracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 如果9个数全部试完都没有找到合适的解法则返回false要求更改之前的放置
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char val) {
        // 遍历行是否存在相同数字
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        //遍历列是否存在相同数字
        for (char[] chars : board) {
            if (chars[col] == val) {
                return false;
            }
        }

        // 遍历九宫格内是否存在相同数字
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
