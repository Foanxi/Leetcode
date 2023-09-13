package middle;

/**
 * @author foanxi
 */
public class T100030_minimumMoves {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] grid;
    private int[][] visited;
    private int extraStones;
    private int moves;

    public int minimumMoves(int[][] grid) {
        this.grid = grid;
        this.visited = new int[grid.length][grid[0].length];
        this.extraStones = 0;
        this.moves = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    extraStones += grid[i][j] - 1;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    dfs(i, j);
                }
            }
        }

        return moves;
    }

    private void dfs(int x, int y) {
        visited[x][y] = 1;
        moves++;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && visited[newX][newY] == 0) {
                if (grid[newX][newY] == 0) {
                    return;
                } else if (grid[newX][newY] > 1) {
                    dfs(newX, newY);
                } else {
                    visited[newX][newY] = 2; // mark this cell as a "hole"
                }
            }
        }
    }
}
