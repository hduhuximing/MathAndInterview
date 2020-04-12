package offer;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        String line = "";
//        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
//        while ((line = bff.readLine()) != null) {
//            String[] s = line.split(" ");
//            String curr = s[0] + s[1];
//            int len = s[0].length() + s[1].length();
//            StringBuilder str1 = new StringBuilder();
//            StringBuilder str2 = new StringBuilder();
//            for (int i = 0; i < curr.length(); i++) {
//                if (i % 2 == 0) {
//                    str1.append(curr.charAt(i));
//                } else {
//                    str2.append(curr.charAt(i));
//                }
//            }
//            char[] ch1 = str1.toString().toCharArray();
//            char[] ch2 = str2.toString().toCharArray();
//            Arrays.sort(ch1);
//            Arrays.sort(ch2);
//            int l1 = 0;
//            int l2 = 0;
//            char[] chs = new char[len];
//            for (int i = 0; i < len; i++) {
//                if (i % 2 == 0) {
//                    chs[i] = ch1[l1++];
//                } else {
//                    chs[i] = ch2[l2++];
//                }
//            }
//            String a = "0123456789abcdefABCDEF";
//            String b = "084C2A6E195D3B7F5D3B7F";
//            for (int i = 0; i < len; i++) {
//                if ((chs[i] >= 'a' && chs[i] <= 'f')
//                        || (chs[i] >= 'A' && chs[i] <= 'F')
//                        || (chs[i] >= '0' && chs[i] <= '9')) {
//                    chs[i] = b.charAt(a.indexOf(chs[i]));
//                }
//            }
//            System.out.println(chs);
//        }
//    }
//}

import java.util.Arrays;
//import java.util.Scanner;

/**
 * 题目：加油站良好出发点问题
 * <p>
 * 这题特殊的地方：
 * 1. 没有给定动态规划的起点，要自己找起点
 * 2. 在环上进行的动态规划，所以是双向的
 * 3. 状态转移不是以点i为单位，而是以区间[start, end)为单位，可以双向扩展
 * 区间[start, end)表示从start位置开始，到end位置的前一个位置
 * <p>
 * 用oil[i] - dis[i] 生成"纯能数组" d[i]
 * 以任意d[i] >= 0的位置为起始点，初始区间[start, end)定义为[i, i+1)
 * <p>
 * 有两个遍历方向，按正常顺时针遍历，或者逆时针方向遍历：
 * res：表示遍历完当前节点后，还剩余多少能量
 * need：要从起点能继续遍历下去，需要多少额外的能量
 * 1. res + d[i] >= 0，可以继续按顺时针扩展，res += d[i]
 * 2. res + d[i] < 0，这个起点不行，按逆时针扩展，寻找新的起点，直到：新增加的能量 + res + d[i] >= 0，则可以继续从顺时针扩展
 * <p>
 * 如果最终能扩展到整个环，则表示找到良好的出发点，如果一直没有出现出现良好出发点，则整个环的点都不是良好出发点
 * <p>
 * 对于找到良好出发点的情况，假设这个点为start，则start前面的点i如果能到达start，则这个点也是良好出发点
 */
//public class Main {
//    static boolean[] solve(long[] oil, long[] dis) {
//        int n = oil.length;
//        boolean[] ans = new boolean[n];
//        int init = calDiff(oil, dis);
//        if (init == -1) {
//            return ans;
//        }
//        return traverse(dis, init);
//    }
//
//    // 双向遍历，直到覆盖整个环的空间
//    static boolean[] traverse(long[] dis, int init) {
//        int n = dis.length;
//        boolean[] ans = new boolean[n];
//        // start只能往逆时针走，end只能往顺时针走
//        // end初始化为init+1，初始区间为[init, init+1]，只包含init这个点
//        int start = init, end = next(init, n);
//        long res = 0, need = 0;
//        do {
//            // 如果遍历完整个环的空间了，这种情况是资源不足，一定是由start逆时针移到end的前一个位置，从而覆盖整个区间
//            // start != init，排除初始情况
//            // 这里把end多计算了一次吗？没有，因为移动到当前的start，在这里还没有减掉它的资源，在下面才处理它的资源
//            if (start != init && start == pre(end, n)) {
//                break;
//            }
//
//            // 先处理start逆时针移动的情况
//            if (dis[start] <= need) {
//                need -= dis[start];
//            } else {
//                // start逆时针找到足够填补need的资源了，把剩下的资源加到res里，need重置
//                res += dis[start] - need;
//                need = 0;
//                // 处理end顺时针移动的情况，end == start时，表示遍历完整个环，也就是考虑完每个点的资源处理，回到start了
////                while (res >= dis[end] && end != start) {
//                // 上面是错误的写法, res可以<=0，用来表示当前区间的资源消耗，不是res >= dis[end]时才进行循环
//                while (res >= 0 && end != start) {
//                    res += dis[end];
//                    end = next(end, n);
//                }
//                // 能满足res >= 0，表示已经遍历整个环，因为end顺时针移动，如果资源不足，则res < 0，如果start逆时针移动直到满足need，
//                // 再下一次时还是要继续移动end
//                if (res >= 0) {
//                    // start是良好的出发点
//                    ans[start] = true;
//                    // 从start开始逆时针找，能到达start的点也是良好出发点
//                    backFromStart(ans, dis, start, pre(start, n));
//                    break;
//                }
//            }
//            start = pre(start, n);
////        } while (end != next(start, n));
//            // 循环结束的条件：1. 顺时针，end == start, 2. 逆时针，start == init，回到起始点
//        } while (start != init);
//        return ans;
//    }
//
//    static void backFromStart(boolean[] ans, long[] dis, int init, int start) {
//        int n = dis.length;
//        // 逆时针遍历只考虑需求
//        long need = 0;
//        while (start != init) {
//            if (dis[start] >= need) {
//                ans[start] = true;
//                // need重置，因为再往前遍历，会以当前start为终点，不是起始的start
//                need = 0;
//            } else {
//                need -= dis[start];
//            }
//            start = pre(start, n);
//        }
//    }
//
//    // next()用来计算环的下一个位置，pre()用来计算环的前一个位置
//    static int next(int i, int n) {
//        return i == n - 1 ? 0 : i + 1;
//    }
//
//    static int pre(int i, int n) {
//        return i == 0 ? n - 1 : i - 1;
//    }
//
//    static int calDiff(long[] oil, long[] dis) {
//        int n = oil.length;
//        int init = -1;
//        for (int i = 0; i < n; i++) {
//            dis[i] = oil[i] - dis[i];
//            if (dis[i] >= 0) {
//                init = i;
//            }
//        }
//        return init;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long[] oil = new long[n];
//        for (int i = 0; i < n; i++) {
//            oil[i] = sc.nextLong();
//        }
//        long[] dis = new long[n];
//        for (int i = 0; i < n; i++) {
//            dis[i] = sc.nextLong();
//        }
//        boolean[] ans = solve(oil, dis);
//        StringBuilder sb = new StringBuilder();
//        for (boolean i : ans) {
//            sb.append(i ? 1 : 0).append(" ");
//        }
//        System.out.println(sb.substring(0, sb.length() - 1));
//    }
//}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int[] node1 = new int[N1];
        for (int i = 0; i < N1; i++) {
            node1[i] = sc.nextInt();
        }
        int N2 = sc.nextInt();
        int[] node2 = new int[N2];
        for (int i = 0; i < N2; i++) {
            node2[i] = sc.nextInt();
        }
        int[] res = new int[N2 + N1];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        for (; i < N1 + N2; i++) {
            if (index1 != N1 && index2 != N2) {
                if (node1[index1] > node2[index2]) {
                    res[i] = node2[index2++];
                } else {
                    res[i] = node1[index1++];
                }
            } else {
                break;
            }
        }
        while (index1 != N1) {
            res[i++] = node1[index1++];
        }
        while (index2 != N2) {
            res[i++] = node2[index2++];
        }
        StringBuilder str=new StringBuilder();
        for (int curr:res) {
            str.append(curr+" ");
        }
        System.out.println(str.toString().trim());
    }
}


