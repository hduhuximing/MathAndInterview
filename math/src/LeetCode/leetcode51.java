package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/30 11:11 上午
 * @descirption N皇后
 */
public class leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int[] queue = new int[n];
        help(res, queue, 0);
        return res;
    }

    private void help(List<List<String>> res, int[] queue, int row) {
        if (row == queue.length) {
            add(queue, res);
            return ;
        }
        for (int i = 0; i < queue.length; i++) {
            queue[row] = i;
            if (isValid(queue, row)) {
                help(res, queue, row + 1);
            }
        }
    }

    private boolean isValid(int[] queue, int row) {
        for(int i=0;i<row;i++){
            //同一列
            if(queue[i]==queue[row]){
                return false;
            }
            //斜角
            if(Math.abs(i-row)==Math.abs(queue[i]-queue[row])){
                return false;
            }
        }
        return true;
    }

    private void add(int[] queue, List<List<String>> res) {
        ArrayList<String> list = new ArrayList<>();
        //行
        for (int i = 0; i < queue.length; i++) {
            StringBuilder str = new StringBuilder();
            //列
            for (int j = 0; j < queue.length; j++) {
                if (j == queue[i]) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            list.add(str.toString());
        }
        res.add(new ArrayList<>(list));
    }
}
