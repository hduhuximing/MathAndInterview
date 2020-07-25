package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/14 9:37 下午
 * @description
 */
public class leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        help(nums.length,res,list,0);
        return res;
    }

    private void help(int len, List<List<Integer>> res, List<Integer> list, int index) {
        if(index==len){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <len ; i++) {
            Collections.swap(list,i,index);
            help(len,res,list,index+1);
            Collections.swap(list,i,index);
        }
    }
}
