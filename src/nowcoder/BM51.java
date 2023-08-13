package nowcoder;

/**
 * @author foanxi
 */
public class BM51 {
    public int MoreThanHalfNum_Solution(int[] numbers) {
        int[] map = new int[10001];
        for (int number : numbers) {
            map[number]++;
            if (map[number] > numbers.length / 2) {
                return number;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BM51().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
