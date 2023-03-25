package middle;

public class T54_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix =new int[n][n];
        int loop=n/2;
        int start_x=0;
        int start_y=0;
        int offset=1;
        int count=1;
        while (loop>0){
            int x=start_x;
            int y=start_y;

            //模拟从左到右
            for (;y<start_y+n-offset;y++){
                matrix[start_x][y]=count++;
            }

            //模拟从上到下
            for (;x<start_x+n-offset;x++){
                matrix[x][y]=count++;
            }

            //模拟从右到左
            for (;y>start_y;y--){
                matrix[x][y]=count++;
            }

            for (;x>start_x;x--){
                matrix[x][start_y]=count++;
            }

            //进入下一圈
            loop--;
            start_x+=1;
            start_y+=1;
            offset+=2;
        }
        //如果是奇数层，那么最中间的位置需要单独赋值
        if (n%2==1)matrix[n/2][n/2]=count;
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = new T54_generateMatrix().generateMatrix(3);
        for (int[] out:ints) {
            for (int temp:out) {
                System.out.printf("%3d",temp);
            }
            System.out.println();
        }
    }
}
