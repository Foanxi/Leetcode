package offer2;

import java.util.Arrays;

public class T3 {
    public int[] countBits2(int n) {
        if (n == 0){
            return new int[]{0};
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        int k = 0;
        for (int i = 2; i <= n; i++) {
            if (i == Math.pow(2, k+1)) {
                k++;
            }
            res[i] = res[(int) (i - Math.pow(2, k))] + 1;
        }
        return res;
    }

    public int[] countBits(int n) {
        if (n == 0){
            return new int[]{0};
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        int k = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 ==1){
                res[i] = res[i-1] + 1;
            }else {
                res[i] = res[i>>1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T3().countBits(5)));
    }
}
