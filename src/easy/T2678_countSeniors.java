package easy;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T2678_countSeniors {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(i -> Integer.parseInt(i.substring(12, 14)) > 60).count();
    }
}
