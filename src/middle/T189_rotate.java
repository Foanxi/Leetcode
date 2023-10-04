package middle;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T189_rotate {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
    }

    public void reverse(int l, int r, int[] arr) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int count = gcd(n, k);
        for (int i = 0; i < count; i++) {
            int cur = i;
            int prev = nums[i];
            do {
                int next = (cur + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
            } while (i != cur);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {-1, -100, 3, 99};
        new T189_rotate().rotate(arr2, 2);
        System.out.println(Arrays.toString(arr2));
    }
}
