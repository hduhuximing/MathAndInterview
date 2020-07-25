package com.zijie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/12 10:45 下午
 * @description
 */
public class manyNum {

    public static void main(String[] args) throws FileNotFoundException {
        long numOfNumbers = 50000000L;
        int pieces = 100;
        //均为相对路径，且desFolder手动创建
        String sourceFile = "data.txt";
        String desFolder = "pieces_small";
        String desFile = "data_sorted.txt";

        generateData(sourceFile, numOfNumbers);
        sortPieces(sourceFile, desFolder, numOfNumbers, pieces);
        heapSort(desFile, desFolder, numOfNumbers, pieces);

    }

    //产生超大规模的随机数
    public static void generateData(String filename, long numOfNumbers) throws FileNotFoundException {
        Random rand = new Random();
        File file = new File(filename);
        PrintWriter pw = new PrintWriter(file);
        for (int i = 0; i < numOfNumbers; i++)
            pw.println(rand.nextInt());
        pw.close();
    }

    //分块排序
    public static void sortPieces(String source, String desFolder, long numOfNumbers, int pieces) throws FileNotFoundException {
        if (numOfNumbers / pieces > Integer.MAX_VALUE) {
            System.out.println("子块长度超过Integer.MAX_VALUE");
            return;
        }
        Scanner sc = new Scanner(new File(source));
        long count = 0L;
        int piecesLength = (int) numOfNumbers / pieces;
        File out = null;
        ArrayList<Integer> list = null;
        PrintWriter pw = null;
        while (sc.hasNext()) {
            if (count % piecesLength == 0) {
                if (list != null) {
                    Collections.sort(list);
                    pw = new PrintWriter(out);
                    for (Integer num : list)
                        pw.println(num);
                    pw.flush();
                }
                list = new ArrayList<>(piecesLength);
                out = new File(desFolder + "/data" + count / piecesLength + ".txt");
            }
            list.add(sc.nextInt());
            count++;
        }
        //余下的少部分数据存入最后一个文件
        Collections.sort(list);
        pw = new PrintWriter(out);
        for (Integer num : list)
            pw.println(num);
        pw.flush();
        sc.close();
        pw.close();
    }

    public static void heapSort(String desFile, String piecesFolder, long numOfNumbers, int pieces) throws FileNotFoundException {
        Scanner[] scanners = new Scanner[pieces];
        Pair[] heap = new Pair[pieces];
        PrintWriter pw = new PrintWriter(new File(desFile));
        for (int i = 0; i < pieces; i++) {
            scanners[i] = new Scanner(new File(piecesFolder + "/data" + i + ".txt"));
            heap[i] = new Pair(scanners[i].nextInt(), i);
        }
        //构造小根堆
        buildMinHeap(heap);
        long i = 0;
        long mod = numOfNumbers / 100;
        while (i < numOfNumbers) {
            //heap[0].value是当前堆中最小值，输出到结果文件中
            pw.println(heap[0].value);
            //如果元素来自第i块，则从第i块文件中补充一个元素到最小值堆
            if (scanners[heap[0].index].hasNext()) {
                heap[0].value = scanners[heap[0].index].nextInt();
            } else {//该文件已读取完毕，则在堆中加入Integer最大值
                heap[0].value = Integer.MAX_VALUE;
            }
            buildMinHeap(heap);
            if (i % mod == 0)
                System.out.format("%.3f%%\n", ((double) i / numOfNumbers) * 100);
            i++;
        }
        pw.flush();
    }

    public static void buildMinHeap(Pair[] nums) {
        int len = nums.length;
        for (int i = len / 2; i >= 0; i--) {
            fixMinHeap(nums, i, len);
        }
    }

    public static void fixMinHeap(Pair[] nums, int root, int size) {
        if (root >= size) {
            return;
        }
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int smaller = root;
        if (left < size && nums[root].value > nums[left].value) {
            smaller = left;
        }
        if (right < size && nums[smaller].value > nums[right].value) {
            smaller = right;
        }
        if (root != smaller) {
            Pair tmp = nums[root];
            nums[root] = nums[smaller];
            nums[smaller] = tmp;
            fixMinHeap(nums, smaller, size);
        }
    }

}

/*
 *Pair用来存储一个数字的值和该值来自哪个文件块
 */
class Pair {
    int value;
    int index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

}
