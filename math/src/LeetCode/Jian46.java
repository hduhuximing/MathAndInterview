package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 6:45 下午
 * @description
 */
public class Jian46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        //c2 c1
        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = c1;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '6')) {
                c1+=c2;
            }
            c2=temp;
        }
        return c1;
    }
}
