package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:37 下午
 * @description
 */
public class Jian61 {
    public boolean isStraight(int[] numbers) {
        int zero = 0;
        int interval = 0;
        if (numbers == null || numbers.length == 0) {
            return false;
        }
       Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zero++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            interval += numbers[i + 1] - numbers[i] - 1;
        }
        return interval <= zero;
    }
}
