package offer;

import java.util.Arrays;

public class T66 {
    public int[] constructArr(int[] a) {
        if (a.length == 0){
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        // 先走下三角
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        // 再走上三角
        int temp = 1;
        for (int j = res.length - 2; j >= 0; j--) {
            temp *= a[j+1];
            res[j] *= temp;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T66().constructArr(new int[]{1, 2, 3, 4, 5})));
    }
}
