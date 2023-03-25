package easy;

public class T833_projectionArea {
    public int projectionArea(int[][] grid) {
        int sum=0;
        //先查找投影在XOY面上的
        for (int[] t:grid) {
            for (int s:t){
                if (s!=0)sum++;
            }
        }

        //查找投影在YOZ面上的
        for (int i=0;i<grid.length;i++){
            int max = grid[i][0];
            for(int j=0;j<grid[i].length;j++){
                max=Math.max(max,grid[i][j]);
            }
            sum+=max;
        }

        //查找投影在YOZ平面上的个数
        for (int i=0;i<grid[0].length;i++) {
            int max = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                max=Math.max(max, grid[j][i]);
            }
            sum += max;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,2}};
        System.out.println(new T833_projectionArea().projectionArea(grid));
    }
}
