package offer;

import java.util.Arrays;

public class T29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null ||matrix.length==0||matrix[0].length==0){
            return new int[]{0};
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (index < res.length){
            for (int col = left;col<=right;col++){
                res[index++] = matrix[up][col];
            }
            if (++up > down){
                break;
            }

            for (int row = up;row<=down;row++){
                res[index++] = matrix[row][right];
            }
            if (right-- < left){
                break;
            }

            for (int col = right;col>=left;col--){
                res[index++] = matrix[down][col];
            }
            if (down-- <up){
                break;
            }
            for (int row = down;row>=up;row--){
                res[index++] = matrix[row][left];
            }
            if (left++ > right){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T29().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
