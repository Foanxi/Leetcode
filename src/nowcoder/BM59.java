package nowcoder;

/**
 * @author foanxi
 */
public class BM59 {

    int res = 0;

    public int Nqueen(int n) {
        traversal(0, n, new int[n][n]);
        return res;
    }

    public void traversal(int cur, int n, int[][] board) {
        if (cur == n) {
            res++;
            return;
        }
        for (int j = 0; j < board[0].length; j++) {
            if (isValid(cur, j, board)) {
                board[cur][j] = 1;
                traversal(cur + 1, n, board);
                board[cur][j] = 0;
            }
        }
    }

    public boolean isValid(int row, int col, int[][] board) {
        // 检查同列是否有放置
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // 检查左上对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // 检查右上对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BM59().Nqueen(3));
    }
}
