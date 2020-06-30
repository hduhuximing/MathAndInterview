package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/2 11:27 上午
 * @description
 */
public class leetcode289 {
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};
        int row = board.length;
        int col = board[0].length;
        int[][] curr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                curr[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int live = 0;

                for (int k = 0; k < 3; k++) {
                    for (int z = 0; z < 3; z++) {
                        if (!(k == 0 && z == 0)) {

                            int ic = i + neighbors[k];
                            int jc = j + neighbors[z];
                            if (ic>=0&&ic<row&&jc>=0&&jc<col&&curr[ic][jc]==1){
                                live++;
                            }
                        }
                    }
                }

                if(curr[i][j]==1&&(live<2||live>3)){
                    board[i][j]=0;
                }
                if(curr[i][j]==0&&live==3){
                    board[i][j]=1;
                }
            }
        }
    }
}
