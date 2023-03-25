package hard;

import offer2.T4;

public class T4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, index = 0;
        int[] res = new int[nums1.length + nums2.length];
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    res[index] = nums1[i];
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    res[index] = nums2[j];
                    j++;
                } else {
                    res[index] = nums1[i];
                    i++;
                    
                }
                index++;
            } else if (i < nums1.length) {
                for (int k = i; k < nums1.length; k++, index++) {
                    res[index] = nums1[k];
                }
                break;
            } else {
                for (int k = j; k < nums2.length; k++, index++) {
                    res[index] = nums2[k];
                }
                break;
            }
        }
        if (res.length % 2 == 1) {
            return res[res.length / 2];
        } else {
            return (double) (res[res.length / 2] + res[res.length / 2 - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new T4_findMedianSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }
}
