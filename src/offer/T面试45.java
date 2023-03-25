package offer;

import java.util.Arrays;

public class T面试45 {
    public String minNumber(int[] nums) {
        String[] map = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(map, (o1, o2) ->
                (o1 + o2).compareTo(o2 + o1)
        );
        StringBuilder sb = new StringBuilder();
        for (String s : map) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T面试45().minNumber(new int[]{
                3, 30, 34, 5, 9
        }));
    }
}
