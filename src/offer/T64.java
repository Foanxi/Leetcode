package offer;

/**
 * @author foanxi
 */
public class T64 {
    // f(n) = f(n-1) + n
    public int sumNums(int n) {
        if (n == 1){
            return 1;
        }
        return sumNums(n-1) + n;
    }

    public static void main(String[] args) {
        System.out.println(new T64().sumNums(3));
    }
}
