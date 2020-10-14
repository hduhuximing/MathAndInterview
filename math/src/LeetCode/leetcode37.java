package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/15 12:38 下午
 * @description
 */
public class leetcode37 {
//    public void solveSudoku(char[][] board) {
//        if (board == null || board.length == 0) {
//            return;
//        }
//        help(board);
//    }
//
//    public boolean help(char[][] board) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == '.') {
//                    for (char k = '1'; k <= '9'; k++) {
//                        //验证当前的数可不可以添加
//                        if (isValid(board, i, j, k)) {
//                            board[i][j] = k;
//                            //添加后重新走判断添加的对不对
//                            if (help(board)) {
//                                return true;
//                            } else {
//                                //还原
//                                board[i][j] = '.';
//                            }
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    //i 行 ,j 列
//    public boolean isValid(char[][] board, int i, int j, char k) {
//        for (int l = 0; l < 9; l++) {
//            if (board[i][l] != '.' && board[i][l] == k) {
//                return false;
//            }
//            if (board[l][j] != '.' && board[l][j] == k) {
//                return false;
//            }
//            if (board[3 * (i / 3) + l / 3][3 * (j / 3) + l % 3] != '.'
//                    && board[3 * (i / 3) + l / 3][3 * (j / 3) + l % 3] == k) {
//                return false;
//            }
//        }
//        return true;
//    }

    List<Integer> list=new ArrayList<>();
    public  void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        help(board);
    }
    public boolean help(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        //验证当前的数可不可以添加
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            list.add(k-'0');
                            //添加后重新走判断添加的对不对
                            if (help(board)) {
                                return true;
                            } else {
                                //还原
                                board[i][j] = '.';
                                list.remove(list.size()-1);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //i 行 ,j 列
    public boolean isValid(char[][] board, int i, int j, char k) {
        for (int l = 0; l < 9; l++) {
            if (board[i][l] != '.' && board[i][l] == k) {
                return false;
            }
            if (board[l][j] != '.' && board[l][j] == k) {
                return false;
            }
            if (board[3 * (i / 3) + l / 3][3 * (j / 3) + l % 3] != '.'
                    && board[3 * (i / 3) + l / 3][3 * (j / 3) + l % 3] == k) {
                return false;
            }
        }
        return true;
    }


}
