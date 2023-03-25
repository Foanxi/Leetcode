package middle;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T1605_restoreMatrix {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        for (int row = 0;row<rowSum.length;row++){
            if (rowSum[row] == 0) {
                continue;
            }
            for (int col=0;col<colSum.length;col++){
                if (colSum[col] == 0) {
                    continue;
                }
                matrix[row][col] = Math.min(rowSum[row],colSum[col]);
                rowSum[row] -= matrix[row][col];
                colSum[col] -= matrix[row][col];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new T1605_restoreMatrix().restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8})));
    }
}
