package middle;

/**
 * @author foanxi
 */
public class T849_maxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int left = 0;
        int right = 0;
        int res = Integer.MIN_VALUE;
        while (right < seats.length) {
            // 先让right找到第一个人
            while (right < seats.length && seats[right] == 0) {
                right++;
            }
            // 区间内
            if (right < seats.length && seats[right] == 1 && seats[left] == 1) {
                res = Math.max(res, (right - left) / 2);
            }
            // 左边界
            else if (right < seats.length && seats[right] == 1 && seats[left] == 0) {
                res = Math.max(res, (right - left));
            }
            // 右边界
            else {
                res = Math.max(res, (right - left) - 1);
            }
            left = right;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T849_maxDistToClosest().maxDistToClosest(new int[]{1, 0}));
    }
}
