package offer;

import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/31 2:58 下午
 * @description
 */
public class te {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int midx = Math.abs(x0 + x1 - x2 - x3);
        int x = Math.abs(x0 - x1) + Math.abs(x2 - x3);
        int midy = Math.abs(y0 + y1 - y2 - y3);
        int y = Math.abs(y0 - y1) + Math.abs(y2 - y3);
        if (midx <= x && midy <= y) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
