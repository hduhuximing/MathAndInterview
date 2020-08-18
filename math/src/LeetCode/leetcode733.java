package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 5:14 下午
 * @description
 */
public class leetcode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int origin = image[sr][sc];
        dfs(image, sr, sc, origin, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int origin, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != origin) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, origin, newColor);
        dfs(image, sr - 1, sc, origin, newColor);
        dfs(image, sr, sc + 1, origin, newColor);
        dfs(image, sr, sc - 1, origin, newColor);


    }
}
