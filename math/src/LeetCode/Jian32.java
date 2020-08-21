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
public class Jian32 {
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

class Solution33 {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        if(level%2==0){
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0,root.val);
        }
        help(res,root.left,level+1);
        help(res,root.right,level+1);
    }
}



class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();

                if(res.size() % 2 == 0)
                    tmp.addLast(node.val); // 偶数层 -> 队列头部
                else
                    tmp.addFirst(node.val); // 奇数层 -> 队列尾部

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
