package middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hujinxu
 */
public class T874_robotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 一个set集合存放x轴，一个存放y轴
        Set<Integer> set = new HashSet<>();
        for (int[] num : obstacles) {
            set.add(num[0] * 60001 + num[1]);
        }

        int x = 0;
        int y = 0;
        int res = 0;
        // 1表示北 0表示东 -1表示南 -2表示西
        int point = 1;
        for (int num : commands) {
            if (num == -2 || num == -1) {
                point = change(point, num);
            } else {
                if (point == 1 || point == -1) {
                    // 检查当前纵轴上是否有障碍物
                    for (int j = 0; j < num; ++j) {
                        if (set.contains(x * 60001 + y + point)) {
                            break;
                        } else {
                            y += point;
                        }
                        res = Math.max((int) (Math.pow(x, 2) + Math.pow(y, 2)), res);
                    }
                } else {
                    for (int j = 0; j < num; ++j) {
                        if (set.contains((x + (point + 1)) * 60001 + y)) {
                            break;
                        } else {
                            x += (point + 1);
                        }
                        res = Math.max((int) (Math.pow(x, 2) + Math.pow(y, 2)), res);
                    }
                }

            }
        }
        return res;
    }

    public int change(int cur, int next) {
        if (next == -1) {
            cur = cur - 1 == -3 ? 1 : cur - 1;
        } else {
            cur = cur + 1 == 2 ? -2 : cur + 1;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] commands = {-2, 8, 3, 7, -1};
        int[][] obstacles = {{-4, -1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2, -1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}};
        System.out.println(new T874_robotSim().robotSim(commands, obstacles));
    }
}
