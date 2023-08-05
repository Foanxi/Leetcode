package nowcoder;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class BM20 {

    int mod = 1000000007;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    public int mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = (r - l) / 2 + l;
        int res = (mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r)) % mod;
        // 合并
        int[] temp = new int[r - l + 1];
        int index1 = l;
        int index2 = mid + 1;
        int tempIndex = 0;
        while (index1 <= mid && index2 <= r) {
            if (arr[index1] <= arr[index2]) {
                temp[tempIndex++] = arr[index1++];
            } else {
                temp[tempIndex++] = arr[index2++];
                res = (res + mid - index1 + 1) % mod;
            }
        }

        while (index1 <= mid) {
            temp[tempIndex++] = arr[index1++];
        }

        while (index2 <= r) {
            temp[tempIndex++] = arr[index2++];
        }
        System.arraycopy(temp, 0, arr, l, temp.length);
        return res;
    }

    public int mergeSort2(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = (r - l) / 2 + l;
        int[] temp = new int[arr.length];
        int p1 = l;
        int p2 = mid + 1;
        int res = (mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r)) % mod;
        for (int i = l; i <= r; ++i) {
            temp[i] = arr[i];
        }
        for (int index = l; index <= r; index++) {
            if (p1 == mid + 1) {
                arr[index] = temp[p2++];
            } else if (p2 == r + 1 || arr[p1] <= arr[p2]) {
                arr[index] = temp[p1++];
            } else {
                arr[index] = temp[p2++];
                res = (res + mid - p1 + 1) % mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(new BM20().InversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }
}
