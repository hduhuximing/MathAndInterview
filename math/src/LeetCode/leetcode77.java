package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/8 10:48 上午
 * @description
 */
public class leetcode77 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        help(1, n, k, list);
        return res;
    }

    private void help(int first, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = first; i < n - (k - list.size()) + 1; i++) {
            list.add(i);
            help(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}