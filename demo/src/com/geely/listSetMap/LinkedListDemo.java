package com.geely.listSetMap;

import com.google.common.collect.LinkedListMultimap;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author ming
 * @version 1.0
 * @date 2019/11/25 11:28 上午
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(next==1){
//                list.remove(next);
                iterator.remove();
            }
            System.out.println(next);
        }
        System.out.println(list);

    }
}
