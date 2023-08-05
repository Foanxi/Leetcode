package offer;

import java.util.Arrays;

public class T51 {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = (r - l) / 2 + l;
        int res = mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r);
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
                res += mid - index1 + 1;
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

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new T51().reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }
}
