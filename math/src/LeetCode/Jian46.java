package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 6:45 下午
 * @description
 */
public class Jian46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int pre = 1;
        int curr = 1;
        for (int i = 1; i < str.length(); i++) {
            int temp = curr;
            if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2' && str.charAt(i) < '6') {
                curr += pre;
            }
            pre = temp;
        }
        return curr;
    }
}
