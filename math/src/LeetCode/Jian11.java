package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 6:37 下午
 * @description
 */
public class Jian11 {
    public int minArray(int[] numbers) {
        // 数组为空
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        // 只有一个元素 或者 本来就有序
        if (numbers.length == 1 || numbers[0] < numbers[numbers.length - 1]) {
            return numbers[0];
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else if (numbers[mid] < numbers[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        return numbers[start];
    }
}
