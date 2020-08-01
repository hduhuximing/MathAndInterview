package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/28 9:23 下午
 * @description
 */
public class leetcode229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int num1 = nums[0];
        int num2 = nums[0];
        for (int num : nums) {
            if (num == num1) {
                count1++;
                continue;
            }
            if (num == num2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                num1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                num2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
                //else做到了去重的功能
            } else if (num == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            list.add(num1);
        }
        if (count2 > nums.length / 3) {
            list.add(num2);
        }
        return list;
    }
}
