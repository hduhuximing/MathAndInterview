package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:08 下午
 * @description
 */
public class Jian58_1 {
    public String reverseWords(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] slist = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = slist.length - 1; i >= 0; i--) {
            //空的跳过
            if (slist[i].equals("")) {
                continue;
            }
            str.append(slist[i] + " ");
        }
        return str.toString().trim();
    }
}

