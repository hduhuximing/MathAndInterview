package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:41 下午
 * @description
 */
public class Jian62 {
    public int lastRemaining(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int curr = (m - 1) % n;
        while (list.size() > 1) {
            list.remove(curr);
            curr = (curr + m - 1) % list.size();
        }
        return list.get(0);
    }

    public int lastRemaining1(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
//        f(n, m) = (f(n - 1, m) + m) % n
//        f(1, m) = 0
        int flag = 0;   //f(1,m) = 0
        for (int i = 2; i <= n; i++) {
            flag = (flag + m) % i; //f(n,m) = (f(n-1,m) + m) % n
            //动态规划的思想，将f(n,m)替换成flag存储
        }
        return flag;
    }
}
