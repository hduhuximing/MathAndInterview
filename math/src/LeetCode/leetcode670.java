package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/27 6:22 下午
 * @description count记录当前数据所在
 */
public class leetcode670 {
    public int maximumSwap(int num) {
        int[] count = new int[10];
        char[] chs = String.valueOf(num).toCharArray();
        //每个数据对应的最后出现的位置，从后面的数据中找出数据替换到前面
        for(int i = 0 ; i < chs.length ; i++) {
            count[(chs[i] - '0')] = i;
        }
        for(int i = 0 ; i < chs.length ; i++) {
            int cur = (chs[i] - '0');
            int j = 9;
            for(;j > cur; j--) {
                if(count[j] > i) {
                    break;
                }
            }
            if(j != cur) {
                swap(chs, i, count[j]);
                return Integer.parseInt(String.valueOf(chs));
            }
        }
        return num;
    }

    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
