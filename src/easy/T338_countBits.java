package easy;

import java.util.Arrays;

public class T338_countBits {
    public int[] countBits(int n) {
        if (n == 0){
            return new int[]{0};
        } else if (n == 1) {
            return new int[]{0,1};
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int count = 1;
        for (int i = 2; i <= n; i++) {
            if (count * 2 == i) {
                count = i;
            }
            res[i] = res[i - count] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T338_countBits().countBits(5)));
    }
}
