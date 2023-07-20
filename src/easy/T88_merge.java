package easy;

/**
 * @author foanxi
 */
public class T88_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
