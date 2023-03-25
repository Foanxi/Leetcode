package offer;

import java.util.HashMap;
import java.util.Map;

public class T56_2 {
    // 对于寻找不同的数字，可以考虑使用异或
    // 难点在于寻找出两个不同的数字，但由于这两个数字不同
    // 那么至少有一个数字的某一位为1而另一个数字该位置为0
//    public int singleNumber(int[] nums) {
//
//    }

    public int singleNumber2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num:map.keySet()){
            if (map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}
