package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/25 3:30 下午
 * @description
 */
public class leetcode463 {
    private int sum = 0;

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int lines = 4;
                if (i > 0 && grid[i - 1][j] == 1) lines--;
                if (i < grid.length - 1 && grid[i + 1][j] == 1) lines--;
                if (j > 0 && grid[i][j - 1] == 1) lines--;
                if (j < grid[0].length - 1 && grid[i][j + 1] == 1) lines--;
                sum += lines;
            }
        }
        return sum;
    }
}
