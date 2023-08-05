package hard;

public class T980_uniquePathsIII {

    int res = 0;

    public int uniquePathsIII(int[][] grid) {
        int x = -1;
        int y = -1;
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        dfs(grid, x, y, count + 1);
        return res;
    }

    public void dfs(int[][] grid, int x, int y, int count) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return;
        }
        if (grid[x][y] == 2) {
            if (count == 0) {
                res++;
            }
            return;
        }
        grid[x][y] = -1;
        // 朝上
        dfs(grid, x, y - 1, count - 1);
        dfs(grid, x, y + 1, count - 1);
        dfs(grid, x + 1, y, count - 1);
        dfs(grid, x - 1, y, count - 1);
        grid[x][y] = 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(new T980_uniquePathsIII().uniquePathsIII(grid));
    }
}
