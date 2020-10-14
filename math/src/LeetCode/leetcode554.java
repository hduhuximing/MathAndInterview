package LeetCode;

import java.util.HashMap;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/19 8:29 下午
 * @description 砖墙 数组最少穿过的数量
 */
public class leetcode554 {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = wall.size();
        for (int num : map.values()) {
            res = Math.min(res, wall.size() - num);
        }
        return res;
    }
}
