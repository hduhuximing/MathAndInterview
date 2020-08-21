package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:19 下午
 * @description
 */
public class Jian59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int i = 0;
        //添加k-1个
        for (; i < k - 1; i++) {
            while (!list.isEmpty() && nums[i] > nums[list.getLast()]) {
                list.removeLast();
            }
            list.add(i);
        }
        for (i = k - 1; i < nums.length; i++) {
            while (!list.isEmpty() && nums[i] > nums[list.getLast()]) {
                list.removeLast();
            }
            list.add(i);
            if (i - list.get(0) >= k) {
                list.remove(0);
            }
            res.add(nums[list.get(0)]);
        }
        int[] res1 = new int[res.size()];
        for (i = 0; i < res.size(); i++) {
            res1[i] = res.get(i);
        }
        return res1;
    }
}
