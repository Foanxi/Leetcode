package middle;

import java.util.ArrayList;
import java.util.List;

public class T1276_numOfBurgers {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        // 判断某个如果超过上限则永远不可能达成目标
        if (tomatoSlices < cheeseSlices) {
            return res;
        } else if (cheeseSlices < tomatoSlices && tomatoSlices / 4 > cheeseSlices) {
            return res;
        }

        // 奶酪数即为汉堡个数
        for (int i = 0; i <= cheeseSlices; i++) {
            if ((i * 2 + (cheeseSlices - i) * 4) == tomatoSlices) {
                res.add(i);
                res.add(cheeseSlices - i);
                break;
            }
        }
        return res;
    }
}
