package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 7:22 下午
 * @description
 */
public class leetcode179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i] + "");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a1 = o1 + o2;
                String a2 = o2 + o1;
                return a2.compareTo(a1);
            }
        });
        if (list.get(0).equals("0")) {
            return "0";
        }
        StringBuilder str = new StringBuilder();
        for (String s : list) {
            str.append(s);
        }
        return str.toString();
    }
}
