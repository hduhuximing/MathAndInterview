package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/18 10:35 上午
 * @description
 */
public class leetcode695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, help(grid, i, j));
                }
            }
        }
        return res;
    }

//    private int help(int[][] grid, int i, int j) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
//            return 0;
//        }
//        int res = 0;
//        grid[i][j] = 0;
//        res = help(grid, i + 1, j) + help(grid, i - 1, j) + help(grid, i, j + 1) + help(grid, i, j - 1) + 1;
//        return res;
//    }

    private int help(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return help(grid, i + 1, j) + help(grid, i, j + 1) + help(grid, i - 1, j) + help(grid, i, j - 1) + 1;
    }
}
