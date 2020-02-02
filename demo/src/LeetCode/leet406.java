package LeetCode;

import java.util.*;

/**
 * @author m
 * @version 1.0
 * @date 2019/11/20 15:24
 */
public class leet406 {
    public int[][] reconstructQueue(int[][] people) {
//        int k = 8;
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2.compareTo(o1));

        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
//        List<Integer> list = new ArrayList<Integer>();
//        Collections.sort(list, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                String s1 = o1 + "" + o2;
//                String s2 = o2 + "" + o1;
//                return s1.compareTo(s2);
//            }
//        });

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

}