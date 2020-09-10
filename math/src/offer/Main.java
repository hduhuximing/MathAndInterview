package offer;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void setAdd(Set<Integer> set, Integer i) {
        //如果已经有这个数了，那么将其移除，再乘以2
        if (!set.add(i)) {
            set.remove(i);
            setAdd(set, i << 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        //前面都是进行正常的输入
        LinkedHashSet<Integer> res = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            //挨个放入，如果已经有这个数字了，那么进行移除，并且乘以2
            setAdd(res, array[i]);
        }
        //后面进行正常的输出
        Iterator<Integer> iterator = res.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) System.out.print(" ");
        }
    }

}












