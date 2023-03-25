package offer;

/**
 * @author foanxi
 */
public class T39 {
    /**
     * 摩尔投票法
     * 超过半数者，最后投票一定会多出票数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public int majorityElement2(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums[nums.length / 2];
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int mid = partition(arr, l, r);
        quickSort(arr, l, mid - 1);
        quickSort(arr, mid + 1, r);
    }

    public int partition(int[] arr, int l, int r) {
        int start = l;
        int pv = arr[l];
        while (l < r) {
            while (l < r && arr[r] > pv) {
                r--;
            }
            while (l < r && arr[l] <= pv) {
                l++;
            }
            swap(arr, l, r);
        }
        swap(arr, start, r);
        return r;
    }

    public void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
