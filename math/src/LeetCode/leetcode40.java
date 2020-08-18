package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 */
public class leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        help(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private void help(int[] candidates, int target, List<List<Integer>> res, int index, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                help(candidates, target - candidates[i], res, i + 1, list);
                list.remove(list.size() - 1);
            }
        }

    }
}
