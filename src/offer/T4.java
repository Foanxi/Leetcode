package offer;

public class T4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length==0){
            return false;
        }
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T4().findNumberIn2DArray(new int[][]{{-1, 3}}, 3));
    }
}
