package commonSort;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/15 5:56 下午
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        Integer len = Integer.valueOf(split[0]);
        Integer water = Integer.valueOf(split[1]);
        String s1 = sc.nextLine();
        String[] position = s1.split(" ");

        int[] positions = new int[position.length];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = Integer.parseInt(position[i]);
        }
        String s2 = sc.nextLine();
        String[] waters = s2.split(" ");

        int[] waterss = new int[waters.length];
        for (int j = 0; j < waters.length; j++) {
            waterss[j] = Integer.parseInt(waters[j]);
        }
        int max = water;
        if (max > len) {
            System.out.println(0);
        }
        int count = 0;
        for (int i = 0; i < position.length; i++) {
            if (positions[i] <= water) {
                water=water+positions[i]+waterss[i];
                if(water>max) {
                    max = water;
                    count++;
                }
                if(max>=len){
                    System.out.println(count);
                }
            }
        }

    }
}