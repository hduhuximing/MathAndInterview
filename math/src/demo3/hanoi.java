package demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/21 7:50 下午
 * @description
 */
public class hanoi {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        hanoi(4, 'A', 'B', 'C');
        int count = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (count != 5) {
                str.append(list.get(i)).append(" ");
                count++;
            }else{
                System.out.println(str.toString().trim());
                count=1;
                str=new StringBuilder().append(list.get(i)).append(" ");
            }
            if(i==list.size()-1){
                System.out.println(str.toString().trim());
            }
        }
    }

    public static void hanoi(int n, char from, char in, char to) {
        if (n == 1) {
            list.add(from + "->" + to);
        } else {
            hanoi(n - 1, from, to, in);
            list.add(from + "->" + to);
            hanoi(n - 1, in, from, to);
        }
    }
}

