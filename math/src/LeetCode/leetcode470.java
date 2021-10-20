package LeetCode;

import java.util.Random;

/**
 * @author ming
 * @version 1.0
 * @date 2020/5/22 12:33 下午
 * @description 随机7 到 随机10
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/xiang-xi-si-lu-ji-you-hua-si-lu-fen-xi-zhu-xing-ji/
 */
public class leetcode470 {

    public int rand10() {
        int res = rand7() + (rand7() - 1) * 7;
        while (res > 40) {
            res = rand7() + (rand7() - 1) * 7;
        }
        return res % 10 + 1;
    }

    public int rand7() {
        Random random = new Random();
        int i = random.nextInt(7);
        return i;
    }
}