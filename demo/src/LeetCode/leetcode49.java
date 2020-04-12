package LeetCode;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/7 6:34 下午
 * @description 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String curr = String.valueOf(chars);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dit = dis(points, i, j);
                    map.put(dit, map.getOrDefault(dit, 0) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int count = entry.getValue();
                if (count >= 2) {
                    res += count * (count - 1);
                }
            }
        }
        return res;
    }

    public int dis(int[][] points, int i, int j) {
        return (points[i][0] - points[j][0])
                        * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1])
                        * (points[i][1] - points[j][1]);
    }
}
