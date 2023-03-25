package easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T349_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int t : nums1) set.add(t);
        for (int i : nums2) {
            if (set.contains(i)) set2.add(i);
        }
        int[] result = new int[set2.size()];
        Iterator<Integer> iterator = set2.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i++] = iterator.next();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1={1,2,3,4,2,3};
        int[] num2={1,32,2,4};
        int[] intersection = new T349_intersection().intersection(num1, num2);
        for (int t:intersection) System.out.print(t+"\t");
    }
}
