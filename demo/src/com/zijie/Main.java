package com.zijie;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/29 12:08 下午
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNext()) {
            n = cin.nextInt();
            String[] str = new String[n];
            Element[] e = new Element[10];

            //初始化
            for (int i = 0; i < 10; i++) {
                e[i] = new Element();
            }

            //获取所有的str,并处理
            for (int i = 0; i < n; i++) {
                str[i] = cin.next();
                //获取每个字母，添加到e[i]中
                int len = str[i].length();
                //标志每个位置的量，1，10，100，1000~~~
                long base = 1;
                for (int j = len - 1; j >= 0; j--, base *= 10) {
                    //将每个数据赋值给相应位置
                    int id = str[i].charAt(j) - 'A';
                    //当前如果是首位置，不能为0
                    if (j == 0) {
                        e[id].flag = 1;
                    }
                    //每个位置的权重
                    e[id].w += base;
                }
            }

            //按照权重排序
            Arrays.sort(e, (o1, o2) -> o1.w > o2.w ? 1 : (o1.w == o2.w ? 0 : -1));

            //如果权重最小的被作为首位置了需要改变
            if (e[0].flag == 1) {
                int index = 1;
                for (; index < 10; index++) {
                    if (e[index].flag == 0) {
                        break;
                    }
                }
                //向前移动
                Element temp = e[index];
                for (; index > 0; index--) {
                    e[index] = e[index - 1];
                }
                e[0] = temp;
            }

            //开始获取最终值
            long sum = 0;
            for (int k = 9; k >= 0; k--) {
                sum += e[k].w * k;
            }
            System.out.println(sum);
        }
    }
}

// 记录字符的权重和标识符，flag=0，表示该字符可以为0，反之，说明该字符不能为0.
class Element {
    //权值
    long w;
    //是否可以为0
    int flag;
}



