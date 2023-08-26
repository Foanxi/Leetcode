package middle;

/**
 * @author foanxi
 */
public class T1267_countServers {

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }

    public int countServers2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] used = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (used[i][j] || grid[i][j] != 1) {
                    continue;
                }
                // 尝试是否能找到一个
                // 同行寻找
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && k != j) {
                        res++;
                        used[i][j] = true;
                        if (!used[i][k]) {
                            used[i][k] = true;
                            res++;
                        }
                        break;
                    }
                }
                // 同列寻找
                if (!used[i][j]) {
                    for (int k = 0; k < m; k++) {
                        if (grid[k][j] == 1 && k != i) {
                            res++;
                            used[i][j] = true;
                            if (!used[k][j]) {
                                used[k][j] = true;
                                res++;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        System.out.println(new T1267_countServers().countServers(grid));
    }
}
