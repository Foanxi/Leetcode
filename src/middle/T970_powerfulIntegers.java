package middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class T970_powerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new TreeSet<>();
        int value1 = 1;
        for (int i = 0; i <= 21; i++) {
            int value2 = 1;
            for (int j = 0; j <= 21 && value2 <= bound; j++) {
                int temp = value1 + value2;
                if (temp <= bound) {
                    res.add(temp);
                }
                value2 *= y;
            }
            value1 *= x;
            if (value1 > bound) {
                break;
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new T970_powerfulIntegers().powerfulIntegers(2, 3, 10));
    }
}
