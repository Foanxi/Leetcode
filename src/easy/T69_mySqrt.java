package easy;

public class T69_mySqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid =  (r + l) / 2;
            long res = (long) mid * mid;
            if (res <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T69_mySqrt().mySqrt(2147395600));
    }
}
