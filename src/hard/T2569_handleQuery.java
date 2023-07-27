package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hujinxu
 */
public class T2569_handleQuery {

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> res = new ArrayList<>();
        long[] nums3 = new long[nums1.length];
        long[] nums4 = new long[nums2.length];
        for (int i = 0; i < nums1.length; ++i) {
            nums3[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; ++i) {
            nums4[i] = nums2[i];
        }
        for (int i = 0; i < queries.length; ++i) {
            int oper = queries[i][0];
            if (oper == 1) {
                int l = queries[i][1];
                int r = queries[i][2];
                for (int j = l; j <= r; ++j) {
                    nums3[j] = nums3[j] == 0 ? 1 : 0;
                }
            } else if (oper == 2) {
                int p = queries[i][1];
                for (int j = 0; j < nums4.length; ++j) {
                    nums4[j] = nums4[j] + nums3[j] * p;
                }
            } else {
                long sum = 0;
                for (long num : nums4) {
                    sum += num;
                }
                res.add(sum);
            }
        }
        long[] last = new long[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            last[i] = res.get(i);
        }
        return last;
    }


    public static void main(String[] args) {
        int[][] queries = {{1, 1, 1}, {2, 1, 0}, {3, 0, 0}};
        System.out.println(Arrays.toString(new T2569_handleQuery().handleQuery(new int[]{1, 0, 1}, new int[]{0, 0, 0}, queries)));
    }
}
