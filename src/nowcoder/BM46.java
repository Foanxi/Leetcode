package nowcoder;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author foanxi
 */
public class BM46 {
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : input) {
            queue.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            res.add(queue.poll());
        }
        return res;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; ++i) {
            res.add(input[i]);
        }
        return res;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = sort(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    public int sort(int[] nums, int left, int right) {
        int start = left;
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            while (left < right && nums[left] <= temp) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, start, left);
        return left;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new BM46().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }
}
