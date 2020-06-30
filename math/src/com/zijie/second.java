package com.zijie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/29 1:16 下午
 */
public class second {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //处理所有数据
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            int len = sc.nextInt();
            if (op == 1) {
                list.add(len);
            } else {
                int index = list.indexOf(len);
                list.remove(index);
            }
            //开始判断
            if (list.size() < 3) {
                System.out.println("NO");
            } else {
                Collections.sort(list);
                long sum=0;
                int j=0;
                for(;j<list.size()-1;j++){
                    sum+=list.get(j);
                }
                if(sum>list.get(j))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
//                long max = 0;
//                long res = 0;
//                for (long cur : list) {
//                    res += cur;
//                    if (cur > max) {
//                        max = cur;
//                    }
//                }
//                if (res > 2 * max) {
//                    System.out.println("YES");
//                } else {
//                    System.out.println("NO");
//                }
//            }
        }
    }
}
