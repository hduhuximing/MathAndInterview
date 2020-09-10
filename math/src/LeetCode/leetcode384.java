package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/7 8:32 下午
 * @description
 */
public class leetcode384 {
    int[] nums;

    public leetcode384(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> index = new ArrayList();
        //目标值索引进列表
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index.add(i);
            }
        }
        //随机产生一个数，在范围内
        Random ra = new Random();
        return index.get(ra.nextInt(index.size()));
    }
}
