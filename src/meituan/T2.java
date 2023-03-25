package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min, max;
        while (scanner.hasNext()) {
            min = scanner.nextInt();
            max = scanner.nextInt();
            List<Integer> result = new ArrayList<>();
            for (int i = min; i <= max; i++) {
                if (isFlower(i)) {
                    result.add(i);
                }
            }
            if (result.size() == 0) {
                System.out.println("no");
                continue;
            }
            for (int num : result) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    public static boolean isFlower(int n) {
        int sum = 0;
        int res = n;
        while (n / 10 != 0 || n % 10 != 0) {
            int num = n % 10;
            sum += Math.pow(num, 3);
            n = n / 10;
        }
        return sum == res;
    }
}
