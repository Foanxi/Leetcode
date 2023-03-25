package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T57_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new T57_2().findContinuousSequence(9)));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int i=1;i<=(target-1)/2;i++){
            int sum = i;
            for (int j=i+1;sum<=target;j++){
                sum += j;
                if (sum == target){
                    int[] tempArray = new int[j-i+1];
                    for (int temp = i;temp<=j;temp++){
                        tempArray[temp-i] = temp;
                    }
                    res.add(tempArray);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
