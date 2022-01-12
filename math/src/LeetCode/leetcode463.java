package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/25 3:30 下午
 * @description
 */
public class leetcode463 {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int line = 4;
                    //四个方向有一个与其相接的line-1
                    if (i > 0 && grid[i - 1][j] == 1) {
                        line--;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        line--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        line--;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        line--;
                    }
                    sum += line;
                }
            }
        }
        return sum;
    }
}
