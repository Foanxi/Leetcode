package middle;

/**
 * @author foanxi
 */
public class T79_board {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, used, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] map, String word, int index, boolean[][] used, int x, int y) {
        if (word.length() == index + 1) {
            return true;
        }
        used[x][y] = true;
        // 上边是否存在
        if (x > 0 && !used[x - 1][y] && map[x - 1][y] == word.charAt(index + 1)) {
            if (dfs(map, word, index + 1, used, x - 1, y)) {
                return true;
            }
        }
        // 下边是否存在
        if (x < map.length - 1 && !used[x + 1][y] && map[x + 1][y] == word.charAt(index + 1)) {
            if (dfs(map, word, index + 1, used, x + 1, y)) {
                return true;
            }
        }
        // 左边是否存在
        if (y > 0 && !used[x][y - 1] && map[x][y - 1] == word.charAt(index + 1)) {
            if (dfs(map, word, index + 1, used, x, y - 1)) {
                return true;
            }
        }
        // 右边是否存在
        if (y < map[0].length - 1 && !used[x][y + 1] && map[x][y + 1] == word.charAt(index + 1)) {
            if (dfs(map, word, index + 1, used, x, y + 1)) {
                return true;
            }
        }
        used[x][y] = false;
        return false;
    }
}
