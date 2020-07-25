package LeetCode;

import java.util.HashMap;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 1:38 下午
 * @description tow sum 不允许出现重复
 */
public class leetcode1 {
    public static int[] twoSum6(int[] nums, int target) {
//        List<int[]> res = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        Arrays.sort(nums);
//        int i = 0;
//        int j = nums.length - 1;
//        while (i < j) {
//            int curr = nums[i] + nums[j];
//            if (curr == target) {
//                res.add(new int[]{nums[i], nums[j]});
//                i++;
//                j--;
//                while (i < j && nums[i] == nums[i - 1]) {
//                    i++;
//                }
//                while (i < j && nums[j] == nums[j + 1]) {
//                    j--;
//                }
//            } else if (curr > target) {
//                j--;
//            } else {
//                i++;
//            }
//        }
//        return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                return new int[]{i, map.get(res)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
//        List<int[]> ints = twoSum6(new int[]{1, 4, 5, 3, 3, 6}, 9);
//        for (int i = 0; i < ints.size(); i++) {
//            String s = Arrays.toString(ints.get(i));
//            System.out.println(s);
//        }
    }
}
