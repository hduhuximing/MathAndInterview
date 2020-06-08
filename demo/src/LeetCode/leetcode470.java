package LeetCode;

import java.util.Random;

/**
 * @author ming
 * @version 1.0
 * @date 2020/5/22 12:33 下午
 * @description 随机7 到 随机10
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