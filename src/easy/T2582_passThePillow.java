package easy;

/**
 * @author foanxi
 */
public class T2582_passThePillow {
    public int passThePillow2(int n, int time) {
        boolean flag = false;
        int minus = n - 1;
        while (n - 1 < time) {
            time -= n - 1;
            flag = !flag;
        }
        if (flag) {
            return time + 1;
        } else {
            return n - time;
        }
    }

    public int passThePillow(int n, int time) {
        time %= (n - 1) * 2;
        return time < n ? time + 1 : n * 2 - time - 1;
    }
}
