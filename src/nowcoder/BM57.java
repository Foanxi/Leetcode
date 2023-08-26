package nowcoder;

public class BM57 {

    boolean[][] used;

    public int solve(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        used = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (used[i][j]) {
            return;
        }
        used[i][j] = true;
        if (i > 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1'}, {'0'}};
        System.out.println(new BM57().solve(grid));
    }
}
