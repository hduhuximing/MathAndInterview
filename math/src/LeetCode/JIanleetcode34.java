package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/2 10:56 上午
 * @description
 */
public class JIanleetcode34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        help(root, sum, res, new ArrayList<>());
        return res;
    }

    private void help(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if(sum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(list));
        }else{
            help(root.left,sum,res,list);
            help(root.right,sum,res,list);
        }
        list.remove(list.size()-1);
    }


}
