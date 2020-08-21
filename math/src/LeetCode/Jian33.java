package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 4:25 下午
 * @description
 */
public class Jian33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return help(postorder, 0, postorder.length - 1);
    }

    private boolean help(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = start;
        int last = postorder[end];
        for (; i < end; i++) {
            if (postorder[i] > last) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (postorder[j] < last) {
                return false;
            }
        }
        return help(postorder, start, i - 1) && help(postorder, i, end - 1);
    }
}
