package easy;

/**
 * @author foanxi
 */
public class T1572_diagonalSum {
    public int diagonalSum(int[][] mat) {
        int left = 0, right = mat[0].length - 1, sum = 0;
        for (int[] ints : mat) {
            if (left != right) {
                sum += ints[left] + ints[right];
            } else {
                sum += ints[left];
            }
            left++;
            right--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = {{7, 3, 1, 9}, {3, 4, 6, 9}, {6, 9, 6, 6}, {9, 5, 8, 5}};
        System.out.println(new T1572_diagonalSum().diagonalSum(nums));
    }
}
