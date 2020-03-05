package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/1 10:11 下午
 * @description 在一个int数组里查找这样的数，它大于等于左侧所有数，小于等于右侧所有数
 */
public class mianshi {

    public static int findNum(int[] arr, int n) {
        if (arr == null) {
            return 0;
        }
        int res[] = new int[n];
        int index = 0;
        res[index++] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                res[index++] = arr[i];
            } else {
                while (index > 0 && res[index - 1] > arr[i]) {
                    index--;
                }
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(res[i]);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 9, 10, 3, 11};
        int count = findNum(arr, 11);
        System.out.println("count:" + count);
    }
}