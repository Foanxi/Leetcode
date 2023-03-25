package easy;

import java.util.Arrays;

public class T66_plusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] a = {9};
        int[] ints = new T66_plusOne().plusOne(a);
        System.out.println(Arrays.toString(ints));
    }
}
