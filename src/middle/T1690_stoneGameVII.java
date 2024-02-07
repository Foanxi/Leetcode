package middle;

public class T1690_stoneGameVII {
    public int stoneGameVII(int[] stones) {
        int alice = 0;
        int bob = 0;
        int left = 0;
        int right = stones.length - 1;
        boolean turn = false;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        while (left <= right) {
            int cur;
            if (stones[left] < stones[right]) {
                sum -= stones[left];
                left++;
            } else {
                sum -= stones[right];
                right--;
            }
            if (!turn) {
                alice += sum;
            } else {
                bob += sum;
            }
            turn = !turn;
        }
        return alice - bob;
    }

    public static void main(String[] args) {
        System.out.println(new T1690_stoneGameVII().stoneGameVII(new int[]{5, 3, 1, 4, 2}));
    }
}
