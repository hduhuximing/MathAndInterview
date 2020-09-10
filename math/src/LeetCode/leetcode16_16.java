package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/6 7:53 下午
 * @description
 */
public class leetcode16_16 {
    public int[] subSort(int[] array) {
        if (array == null || array.length == 0)
            return new int[]{-1, -1};
        int max = array[0];
        int i = 0;
        int right = -1;
        //找比当前小的最右边的
        while (i < array.length) {
            int temp = array[i];
            if (temp < max) right = i;
            max = Math.max(max, temp);
            i++;
        }
        //找比当前大的最左边的
        int min = array[array.length - 1];
        int j = array.length - 1;
        int left = -1;
        while (j >= 0) {
            int temp = array[j];
            if (temp > min) left = j;
            min = Math.min(min, temp);
            j--;
        }

        return new int[]{left, right};
    }
}
