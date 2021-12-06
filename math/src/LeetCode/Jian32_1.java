package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:48 下午
 * @description
 */
public class Jian32_1 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new int[0];
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            res.add(curr.val);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        int[] res1 = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res1[i] = res.get(i);
        }
        return res1;
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        help(res,root,0);
        return res;
    }
    public void help(List<List<Integer>>res,TreeNode root,int level){
        if(root==null){
            return ;
        }
        if(res.size()==level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        help(res,root.left,level+1);
        help(res,root.right,level+1);
    }
}

