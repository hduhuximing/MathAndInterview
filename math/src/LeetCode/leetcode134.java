package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/31 8:08 下午
 * @description
 */
public class leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totle = 0;
        int curr = 0;
        int start_station = 0;
        for (int i = 0; i < gas.length; i++) {
            totle += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                curr = 0;
                start_station = i + 1;
            }
        }
        return totle >= 0 ? start_station : -1;
    }
}
