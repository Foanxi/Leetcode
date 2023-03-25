package middle;

/**
 * @author foanxi
 */
public class T314_canCompleteCircuit {
    /**
     * 从全局考虑，找出能填平剩余油量的
     *
     * @param gas  第i个加油站的油量
     * @param cost 前往下一个油站需要花费cost[i]的油量
     * @return 车子从第i(从0开始)出发可以刚好环绕一圈
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            min = Math.min(min, sum);
        }
        if (sum < 0) {
            return -1;
        }
        if (min >= 0) {
            return 0;
        }
        for (int j = gas.length - 1; j >= 0; j--) {
            min += gas[j] - cost[j];
            if (min >= 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 从局部考虑如果累加过程中出现了负数，那么就代表从0到i都不能作为起始位置
     *
     * @param gas  第i个加油站的油量
     * @param cost 前往下一个油站需要花费cost[i]的油量
     * @return 车子从第i(从0开始)出发可以刚好环绕一圈
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int minSum = Integer.MAX_VALUE;
        int curSum = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            if (curSum<minSum){
                minSum = curSum;
                startIndex=i+1;
            }
        }
        // 这里之所以要取余是因为0的时候会被跳过
        return curSum<0?-1:startIndex%cost.length;
    }
}
