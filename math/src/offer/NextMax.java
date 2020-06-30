package offer;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/5 4:30 下午
 * @description 找出数组中每一个元素右边第一个大于它的数
 */
public class NextMax {
    public static int[] findMax(int[] arry) {
        if (arry.length == 0) {
            return null;
        }
        if (arry.length == 1) {
            return new int[]{-1};
        }
        int len = arry.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(arry[len - 1]);
        arry[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int temp=arry[i];
            while (!stack.isEmpty() && stack.peek() < temp) {
                stack.pop();
            }
            if(stack.isEmpty()){
                arry[i]=-1;
            }else{
                arry[i]=stack.peek();
            }
            stack.push(temp);
        }
        return arry;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int array[] = new int[]{1, 8, 6, 5, 3, 2, 9, 7};
        int res[] = findMax(array);
        for (int num : res) {
            System.out.println(num);
        }
    }
}