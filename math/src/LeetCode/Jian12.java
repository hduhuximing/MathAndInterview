package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 2:53 下午
 * @description 深度遍历+回溯
 */
public class Jian12 {
    public boolean exist(char[][] board, String word) {
        //数组空值判断
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        //创建已经遍历完成的记录位置
        int row = board.length;
        int cow = board[0].length;
        boolean[][] flag = new boolean[row][cow];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cow; j++) {
                if (help(board, i, j, row, cow, word, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    //count 表示遍历成功了几个
    public boolean help(char[][] board, int i, int j, int row, int cow, String word, int count, boolean[][] flag) {
        //跳出条件 越界或者当前值和word的遍历位置不一致或者当前已经遍历过了
        if (i < 0 || i >= row || j < 0 || j >= cow || flag[i][j] || word.charAt(count) != board[i][j]) {
            return false;
        }
        //上面一个没跳出表示当前遍历成功,如果当前已经遍历到最后一个，成功
        if (count == word.length() - 1) {
            return true;
        }
        flag[i][j] = true;
        if (help(board, i + 1, j, row, cow, word, count + 1, flag)
                || help(board, i - 1, j, row, cow, word, count + 1, flag)
                || help(board, i, j + 1, row, cow, word, count + 1, flag)
                || help(board, i, j - 1, row, cow, word, count + 1, flag)) {
            return true;
        }
        //回溯
        flag[i][j] = false;
        return false;
    }
}
