package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/1 11:36 上午
 * @description
 */
public class leetcode200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[m][n] == '1') {
                    res++;
                    bfs(grid, m, n);
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int m, int n) {
        if (m > 0 && m < grid.length && n > 0 && n < grid[0].length && grid[m][n] == '1') {
            grid[m][n] = '2';
            bfs(grid, m + 1, n);
            bfs(grid, m - 1, n);
            bfs(grid, m, n + 1);
            bfs(grid, m, n - 1);
        }
    }
}
