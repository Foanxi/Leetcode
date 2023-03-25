package offer;

public class T56_1 {
    // 对于寻找不同的数字，可以考虑使用异或
    // 难点在于寻找出两个不同的数字，但由于这两个数字不同
    // 那么至少有一个数字的某一位为1而另一个数字该位置为0
    public int[] singleNumbers(int[] nums) {
        // 1.先得到两个不同数字的异或结果
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        //2. 然后找到第一个不同的位置，也即找到第一个1
        int index = 1;
        while ((diff & index) == 0) {
            index <<= 1;
        }
        // 3.使数字根据该位置的不同进行分组分别异或
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & index) == 1) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
