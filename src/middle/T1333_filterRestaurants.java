package middle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author foanxi
 */
public class T1333_filterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res;
        List<int[]> list = Arrays.asList(restaurants);
        if (veganFriendly == 1) {
            list = list.stream().filter(i -> i[2] == 1).collect(Collectors.toList());
        }
        list = list.stream().filter(i -> i[3] <= maxPrice).filter(i -> i[4] <= maxDistance).collect(Collectors.toList());
        res = list.stream().sorted((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            } else {
                return o2[1] - o1[1];
            }
        }).map(i -> i[0]).collect(Collectors.toList());
        return res;
    }
}
