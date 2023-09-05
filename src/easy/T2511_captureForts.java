package easy;

/**
 * @author foanxi
 */
public class T2511_captureForts {
    public int captureForts(int[] forts) {
        int left = -1;
        int res = 0;
        for (int right = 0; right < forts.length; right++) {
            if (left != -1 && ((forts[right] == 1 && forts[left] == -1) || (forts[right] == -1 && forts[left] == 1))) {
                res = Math.max(right - left - 1, res);
                left = right;
            } else if (forts[right] == 1 || forts[right] == -1) {
                left = right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T2511_captureForts().captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
    }
}
