package middle;

import java.util.Arrays;

public class T2171_minimumRemoval {

    public long minimumRemoval(int[] beans) {
        int len = beans.length;
        Arrays.sort(beans);
        // 假设是全部降低到当前这个豆子所需个数
        long res = Long.MAX_VALUE;
        // pre[i]表示从0到i - 1的豆子总数
        long total = 0;
        for (int bean : beans) {
            total += bean;
        }
        for (int i = 0; i < len; i++) {
            // 假设所有豆子保持跟第i颗一样大 j<i的部分全部降为0
            res = Math.min(res, total - (long) beans[i] * (len - i));
        }
        return res;
    }

    public long minimumRemoval2(int[] beans) {
        int len = beans.length;
        Arrays.sort(beans);
        // 假设是全部降低到当前这个豆子所需个数
        long res = Long.MAX_VALUE;
        // pre[i]表示从0到i - 1的豆子总数
        long[] pre = new long[len + 1];
        for (int i = 1; i <= len; i++) {
            pre[i] = beans[i - 1] + pre[i - 1];
        }
        for (int i = 0; i < len; i++) {
            // 假设所有豆子保持跟第i颗一样大 j<i的部分全部降为0
            res = Math.min(res, pre[len] - pre[i + 1] - (long) beans[i] * (len - i - 1) + pre[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T2171_minimumRemoval().minimumRemoval(new int[]{2, 10, 3, 2}));
    }
}
