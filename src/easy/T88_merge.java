package easy;

/**
 * @author foanxi
 */
public class T88_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
        while (index1 >= 0) {
            nums1[index--] = nums1[index1--];
        }
        while (index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        if (n <= 0) {
            return;
        }
        if (m <= 0) {
            temp = nums2;
        } else {
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < m + n; ++i) {
                if (index1 < m && index2 < n && nums1[index1] <= nums2[index2]) {
                    temp[i] = nums1[index1];
                    index1++;
                } else if (index2 >= n) {
                    temp[i] = nums1[index1];
                    index1++;
                } else if (index1 >= m) {
                    temp[i] = nums2[index2];
                    index2++;
                } else {
                    temp[i] = nums2[index2];
                    index2++;
                }
            }
        }
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }
}
