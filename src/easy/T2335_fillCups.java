package easy;

import java.util.Arrays;

public class T2335_fillCups {
    public int fillCups(int[] amount) {
        int result = 0;
        int max = 1;
        while (max>0){
            Arrays.sort(amount);
            max = amount[2];
            amount[2]--;
            amount[1]--;
            result++;
        }
        return result;
    }

    public int fillCups2(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[0] + amount[1]){
            return amount[2];
        }else {
            return (amount[0] + amount[1] + amount[2] + 1) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new T2335_fillCups().fillCups(new int[]{5,4,4}));
    }
}
