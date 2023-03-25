package offer;

/**
 * @author foanxi
 */
public class T40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        quickSort(arr, 0, arr.length - 1);
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = sort(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    public int sort(int[] arr, int left, int right) {
        int start = left;
        int index = arr[left];
        while (left < right) {
            while (left < right && arr[right] > index) {
                right--;
            }
            while (left < right && arr[left] <= index) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, start, right);
        return right;
    }

    public void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
