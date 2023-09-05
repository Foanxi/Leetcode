package middle;

/**
 * @author foanxi
 */
public class T2240_waysToBuyPensPencils {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int res = 0;
        if (cost1 < cost2) {
            int temp = cost1;
            cost1 = cost2;
            cost2 = temp;
        }
        for (int i = 0; i * cost1 <= total; i++) {
            res += (total - cost1 * i) / cost2 + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T2240_waysToBuyPensPencils().waysToBuyPensPencils(20, 10, 5));
    }
}
