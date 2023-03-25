package offer;

public class T12 {
    boolean flag;

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                traversal(board, visited, word, 0, i, j);
            }
        }
        return flag;
    }

    public void traversal(char[][] board, boolean[][] visited, String word, int index, int row, int col) {
        if (board[row][col] != word.charAt(index)) {
            return;
        } else if (index == word.length() - 1) {
            flag = true;
            return;
        }

        // 首先标记当前位置已经被使用
        visited[row][col] = true;
        // 四个方向
        // 上
        if (row > 0 && !visited[row - 1][col]) {
            traversal(board, visited, word, index + 1, row - 1, col);
        }
        if (flag) {
            return;
        }
        // 下
        if (row < board.length - 1 && !visited[row + 1][col]) {
            traversal(board, visited, word, index + 1, row + 1, col);
        }
        if (flag) {
            return;
        }
        // 左
        if (col > 0 && !visited[row][col - 1]) {
            traversal(board, visited, word, index + 1, row, col - 1);
        }
        if (flag) {
            return;
        }
        // 右
        if (col < board[0].length - 1 && !visited[row][col + 1]) {
            traversal(board, visited, word, index + 1, row, col + 1);
        }
        if (flag) {
            return;
        }
        visited[row][col] = false;
    }
}
