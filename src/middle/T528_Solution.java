package middle;

public class T528_Solution {
    int sum = 0;
    int[] pre;

    public T528_Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i - 1] + w[i];
            sum += w[i];
        }

    }

    public int pickIndex() {
        int rand = (int) (Math.random() * sum + 1);
        return binarySearch(pre, rand);
    }

    /**
     * 寻找区间位于下标为i的空间内
     *
     * @param arr    数组
     * @param target 寻找的数字
     * @return 区间下标
     */
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
