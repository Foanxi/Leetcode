package offer;

public class T62 {
    public static void main(String[] args) {
        System.out.println(new T62().lastRemaining(5, 3));
    }

    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }

    public int lastRemaining2(int n, int m) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        int right = n - 1;
        int cur = 0;
        while (right >= 1) {
            for (int i = 0; i < m - 1; i++) {
                cur = (cur + 1) % (right + 1);
            }
            move(array, cur, right);
            right--;
        }
        return array[0];
    }

    public void move(int[] array, int index, int limit) {
        for (int i = index; i < limit; i++) {
            array[i] = array[i + 1];
        }
    }
}
