package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 2:26 下午
 * @description
 */
public class leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        List<Integer> pre = null;
        for (int i = 1; i < numRows; i++) {
            pre = triangle.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                curr.add(pre.get(j) + pre.get(j + 1));
            }
            curr.add(1);
            triangle.add(curr);
        }
        return triangle;
    }
}
