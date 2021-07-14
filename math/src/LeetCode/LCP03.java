package LeetCode;

public class LCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        char[] com = command.toCharArray();
        //保存最初走过的路
        int[][] path = new int[com.length][2];
        //向着x和y走的路径
        int xStep = 0;
        int yStep = 0;
        int index = 0;
        for (char c : com) {
            if (c == 'U') {
                yStep++;
            }
            if (c == 'R') {
                xStep++;
            }
            path[index][0] = xStep;
            path[index][1] = yStep;
            index++;
        }
        for (int[] obstacle : obstacles) {
            if (obstacle[0] >= x && obstacle[1] >= y) {
                continue;
            }
            if (check(path, obstacle[0], obstacle[1], xStep, yStep)) {
                return false;
            }
        }
        return check(path, x, y, xStep, yStep);
    }

    private boolean check(int[][] path, int x, int y, int xStep, int yStep) {
        for (int[] pa : path) {
            if ((x - pa[0]) % xStep == 0
                    && (y - pa[1]) % yStep == 0
                    && (x - pa[0]) / xStep == (y - pa[1]) / yStep) {
                return true;
            }
        }
        return false;
    }
}
