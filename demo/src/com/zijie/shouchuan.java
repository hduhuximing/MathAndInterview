package com.zijie;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/11 4:05 下午
 * @description
 */
public class shouchuan {
//    链接：https://www.nowcoder.com/questionTerminal/429c2c5a984540d5ab7b6fa6f0aaa8b5
//    来源：牛客网

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    //n个串珠
        int m = sc.nextInt();    //手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次
        int c = sc.nextInt();    //颜色一共有c种
        int count = 0;
        //存颜色对应的串珠位置
        Map<Integer, List<Integer>> map = new HashMap<>();
        //串珠位置
        for (int i = 0; i < n; i++) {
            //颜色数位置
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                //获取当前的颜色
                int key = sc.nextInt();
                if (!map.containsKey(key)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(key, list);
                } else {
                    List<Integer> list = map.get(key);
                    list.add(i);
                }
            }
        }
        for (int i = 1; i <= c; i++) {
            boolean flag = false;
            List<Integer> list = map.get(i);
            if (list.size() == 1) {
                continue;
            } else {
                for (int j = 0; j < list.size() - 1; j++) {
                    //如果前后间隔小于当前m，表示当前珠子有问题
                    if (list.get(j + 1) - list.get(j) < m) {
                        count++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    if ((n - list.get(list.size() - 1) + list.get(0)) < m) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
