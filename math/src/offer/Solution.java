package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/12 4:23 下午
 * @description
 */
public class Solution {

    /**
     * 获取最大可同事办公员工数
     *
     * @param pos char字符型二维数组 工位分布
     * @return int整型
     */
    private int count = 0;

    public int GetMaxStaffs(char[][] pos) {
        // write code here
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[i].length; j++) {
                if (pos[i][j] == '.') {
                    boolean flag = help(pos, i, j + 1)
                            && help(pos, i, j - 1)
                            && help(pos, i + 1, j)
                            && help(pos, i - 1, j);
                    if (flag) {
                        count++;
                        pos[i][j] = '#';
                    }
                }
            }
        }
        return count;
    }

    private boolean help(char[][] pos, int i, int j) {
        if (i < 0 || i >= pos.length || j < 0 || j >= pos[0].length) {
            return true;
        }
        if (pos[i][j] == '#') {
            return false;
        }
        return true;
    }
}

//    /**
//     * 根据顾客属性计算出顾客排队顺序
//     *
//     * @param a int整型一维数组 顾客a属性
//     * @param b int整型一维数组 顾客b属性
//     * @return int整型一维数组
//     */
//    public int[] WaitInLine(int[] a, int[] b) {
//        // write code here
//        List<Integer> list = new ArrayList<>();
//        int len = a.length;
//        for (int i = 0; i < len; i++) {
//            list.add(i);
//        }
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (a[o1] < b[o1]) {
//                    return a[o1] - a[o2];
//                } else {
//                    return b[o1] - b[o2];
//                }
//            }
//        });
//
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i) + 1;
//        }
//        return res;
//    }