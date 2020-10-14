package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/12 8:31 下午
 * @description 中序 后序-》先序
 */
public class midafter {
    static int postStack[] = {3, 4, 2, 6, 5, 1}; // 后序序列
    static int inStack[] = {3, 2, 4, 1, 6, 5}; // 中序序列

    public static void get_pre_order(int root, int start, int end) {
        // 三个参数分别是根节点index，中序序列首个和最后一个元素的index
        if (start > end) // 此时元素位置都已经确定了，递归结束
            return;
        int i = start;
        while (i < end && inStack[i] != postStack[root]) i++;
        // 在中序序列中找到根节点下标i, 左边的是左子树，右边是右子树
        System.out.println(postStack[root]); // 要输出前序序列， 每次先输出一棵树的根节点
        get_pre_order(root - (end - i) - 1, start, i - 1); // 遍历左子树，对第一个参数, 左子树根节点为根节点先减去右子树（end-i）,再减一
        get_pre_order(root - 1, i + 1, end);// 遍历右子树，根节点是原先根节点减一，把上图后序遍历一下就知道了
    }

    public static void main(String[] args) {
        //根节点长度，开始0 ，总长度
        get_pre_order(5, 0, 5);

    }
}
