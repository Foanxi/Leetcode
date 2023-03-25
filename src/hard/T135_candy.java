package hard;

import java.util.Arrays;

public class T135_candy {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);

        // 先从左往右遍历
        for (int i = 1; i < result.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                result[i] = result[i - 1] + 1;
            }
        }

        // 再从右往左
        for (int i = result.length - 2; i >= 0; i--) {
            if (ratings[i] >= ratings[i + 1]) {
                result[i] = Math.max(result[i + 1] + 1,result[i]);
            }
        }

        int total = 0;
        for (int num : result) {
            total += num;
        }

        return total;
    }
}
