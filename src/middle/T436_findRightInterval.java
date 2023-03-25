package middle;

import java.util.ArrayList;
import java.util.List;

public class T436_findRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        if(intervals.length == 1){
            res[0]=-1;
            return res;
        }
        List<interval> list = new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            list.add(new interval(intervals[i][0],intervals[i][1]));
        }
        for (int i=0;i<list.size();i++){
            int index = -1;
            for (int j=0;j<list.size();j++){
                if (list.get(i).right <= list.get(j).left){
                    if (index != -1 &&list.get(index).left <= list.get(j).left){
                        continue;
                    }
                    index = j;
                }
            }
            res[i] = index;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{0,1},{3,4}};
        int[] rightInterval = new T436_findRightInterval().findRightInterval(intervals);
        for (int n:rightInterval) {
            System.out.print(n+"\t");
        }
    }
}



class interval{
    int left;
    int right;

    public interval(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
