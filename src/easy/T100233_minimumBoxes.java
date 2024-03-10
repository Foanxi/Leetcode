package easy;

import java.util.Arrays;

public class T100233_minimumBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int res = 0;
        for (int i = capacity.length - 1; i >= 0 && sum >= 0; i--) {
            sum -= capacity[i];
            res++;
        }
        return res;
    }
}
