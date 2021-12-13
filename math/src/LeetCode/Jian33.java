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
    //先遍历找到第一个大于根节点的数据，他后面的数据也都应该大于跟
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
        //每次遍历都是拆分成左子树和右子树
        //能走到这里证明前面的都过了
        return help(postorder, start, i - 1) && help(postorder, i, end - 1);
    }
}
