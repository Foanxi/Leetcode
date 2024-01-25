package easy;


public class T2765_alternatingSubarray {
    public int alternatingSubarray(int[] nums) {
        boolean flag;
        int res = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] - nums[i] == 1) {
                flag = true;
                int len = 2;
                for (int j = i + 1; j < nums.length; j++) {
                    res = Math.max(res, len);
                    if (j != nums.length - 1) {
                        if (flag && nums[j + 1] - nums[j] != -1) {
                            break;
                        } else if (!flag && nums[j + 1] - nums[j] != 1) {
                            break;
                        }
                    }
                    len++;
                    flag = !flag;

                }
            }
        }
        return res == 0 ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new T2765_alternatingSubarray().alternatingSubarray(new int[]{4, 5, 6}));
    }
}
