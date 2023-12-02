package middle;

import java.util.HashMap;
import java.util.Map;

public class T2661_firstCompleteIndex {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rawLen = mat.length;
        int colLen = mat[0].length;
        int[] raw = new int[rawLen];
        int[] col = new int[colLen];
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < rawLen; i++) {
            for (int j = 0; j < colLen; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int curRow = map.get(arr[i])[0];
            int curCol = map.get(arr[i])[1];
            raw[curRow]++;
            col[curCol]++;
            if (raw[curRow] == colLen || col[curCol] == rawLen) {
                return i;
            }
        }
        return -1;
    }
}
