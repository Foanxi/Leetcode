package middle;

import java.util.Arrays;

public class T100247_maximumHappinessSum {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        Arrays.sort(happiness);
        int round = 0;
        for (int i = happiness.length - 1; i >= 0 && round < k; i--) {
            sum += Math.max(happiness[i] - round, 0);
            round++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new T100247_maximumHappinessSum().maximumHappinessSum(new int[]{11, 1, 42}, 3));
    }
}
