package easy;

/**
 * @author foanxi
 */
public class T2103_countPoints {
    public int countPoints(String rings) {
        boolean[][] color = new boolean[10][3];
        for (int i = 0; i < rings.length(); i += 2) {
            boolean[] booleans = color[rings.charAt(i + 1) - '0'];
            if (rings.charAt(i) == 'R') {
                booleans[0] = true;
            } else if (rings.charAt(i) == 'G') {
                booleans[1] = true;
            } else {
                booleans[2] = true;
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (color[i][0] && color[i][1] && color[i][2]) {
                res++;
            }
        }
        return res;
    }
}
