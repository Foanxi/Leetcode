package meituan;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cur;
        int count;
        while (scanner.hasNext()) {
            double sum = 0.0;
            cur = scanner.nextDouble();
            count = scanner.nextInt();
            for (int i = 0; i < count; i++) {
                sum += cur;
                cur = Math.sqrt(cur);
            }
            System.out.println(sum);
        }
    }
}
