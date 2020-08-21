package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 10:35 上午
 * @description
 */
public class Jian38 {
    List<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        char[] ch = s.toCharArray();
        help(ch, 0);
        String[] str = new String[list.size()];
        return list.toArray(str);

    }

    private void help(char[] ch, int index) {
        if (index == ch.length) {
            String str = new String(ch);
            list.add(str);
            return;
        }
        for (int i = index; i < ch.length; i++) {
            if (canSwap(ch, i, index)) {
                swap(ch, i, index);
                help(ch, index + 1);
                swap(ch, i, index);
            }
        }
    }

    private boolean canSwap(char[] ch, int end, int start) {
        for (int j = start; j < end; j++) {
            if (ch[j] == ch[end]) {
                return false;
            }
        }
        return true;
    }

    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
