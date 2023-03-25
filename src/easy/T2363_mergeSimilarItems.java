package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2363_mergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, (o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(items2, (o1, o2) -> o1[1] - o2[1]);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < items1.length && j < items2.length) {
            List<Integer> temp = new ArrayList<>();
            if (items1[i][0] == items2[j][0]) {
                temp.add(items1[i][0]);
                temp.add(items1[i][1] + items2[j][1]);
                i++;
                j++;
            } else if (items1[i][0] < items2[j][0]) {
                temp.add(items1[i][0]);
                temp.add(items1[i][1]);
                i++;
            } else {
                temp.add(items2[j][0]);
                temp.add(items2[j][1]);
                j++;
            }
            res.add(temp);
        }

        while (i < items1.length) {
            List<Integer> temp = new ArrayList<>();
            temp.add(items1[i][0]);
            temp.add(items1[i][1]);
            i++;
            res.add(temp);
        }
        while (j < items2.length) {
            List<Integer> temp = new ArrayList<>();
            temp.add(items1[j][0]);
            temp.add(items1[j][1]);
            j++;
            res.add(temp);
        }
        return res;
    }
}
