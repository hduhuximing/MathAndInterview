package com.zijie;

import java.util.Random;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/11 11:31 上午
 * @description
 */
public class xushuichi {
    public static int[] chizi(int k[], int m) {
        int[] b = new int[m];
        if (k.length <= m) {
            return b;
        } else {
            for (int i = 0; i < k.length; i++) {
                if (i < m) {
                    b[i] = k[i];
                } else {
                    int r = new Random().nextInt(i + 1);
                    if (r < m) {
                        b[r] = b[i];
                    }
                }
            }
        }
        return b;
    }
}
