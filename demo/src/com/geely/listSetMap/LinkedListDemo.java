package com.geely.listSetMap;

import com.google.common.collect.LinkedListMultimap;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2019/11/25 11:28 上午
 */
class Element {
    long w;
    int flag;
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();

        Element[] e = new Element[10];
        Arrays.sort(e, (o1, o2) -> o1.w > o2.w ? 1 : (o1.w == o2.w ? 0 : -1));

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 1) {
//                list.remove(next);
                iterator.remove();
            }
            System.out.println(next);
        }
        System.out.println(list);

    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) == 0) {
                    list.add(nums[i]);
                    break;
                }
            }
        }
        return list;
    }
}
