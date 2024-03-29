package middle;

/**
 * @author foanxi
 */
public class T8049_isReachableAtTime {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t == 1) {
            return false;
        }
        return Math.max(Math.abs(fx - sx), Math.abs(fy - sy)) <= t;
    }
}
