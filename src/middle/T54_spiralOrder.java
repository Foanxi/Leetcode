package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author foanxi
 */
public class T54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (res.size() < matrix.length * matrix[0].length) {
            // 从左向右
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            for (int j = up; j <= down && res.size() < matrix.length * matrix[0].length; j++) {
                res.add(matrix[j][right]);
            }
            right--;
            // 从右往左
            for (int i = right; i >= left && res.size() < matrix.length * matrix[0].length; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            for (int j = down; j >= up && res.size() < matrix.length * matrix[0].length; j--) {
                res.add(matrix[j][left]);
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new T54_spiralOrder().spiralOrder(grid));
    }
}
