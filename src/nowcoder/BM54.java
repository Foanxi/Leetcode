package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class BM54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length; ++i) {
            if (num[i] > 0) {
                return res;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1, right = num.length - 1;
            while (left < right) {
                if (num[left] + num[right] < -num[i]) {
                    left++;
                } else if (num[left] + num[right] > -num[i]) {
                    right--;
                } else {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(num[i]);
                    ans.add(num[left]);
                    ans.add(num[right]);
                    res.add(ans);
                    while (left < right && num[right] == num[right - 1]) {
                        right--;
                    }
                    while (left < right && num[left] == num[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BM54().threeSum(new int[]{1, -1, -1, 0}));
    }
}
