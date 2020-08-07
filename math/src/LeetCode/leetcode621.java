package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/7 11:26 上午
 * @description
 */
public class leetcode621 {
    public int leastInterval(char[] tasks, int n) {
        //100%
        int res;
        int l = tasks.length;
        int[] num = new int[26];
        for (int i = 0; i < l; i++) {
            num[tasks[i] - 'A']++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        res = (max - 1) * (n + 1);
        //获取等于最大值的，模仿桶
        for (int j = 0; j < 26; j++) {
            if (num[j] == max) {
                res++;
            }
        }
        return Math.max(res, l);
        //麻烦
//        int[] nums = new int[26];
//        for (char task : tasks) {
//            nums[task - 'A']++;
//        }
//        //从大到小
//        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
//        for (int num : nums) {
//            queue.add(num);
//        }
//        int res = 0;
//        //每次选取最多的n+1个，每次减去一个顺序不会改变，不够可以停止一下
//        while (!queue.isEmpty()) {
//            List<Integer> temp = new ArrayList<>();
//            int i = 0;
//            //选n+1个
//            while (i <= n) {
//                if (!queue.isEmpty()) {
//                    temp.add(queue.poll() - 1);
//                } else {
//                    queue.poll();
//                }
//                res++;
//                i++;
//                if (queue.isEmpty() && temp.size() == 0) {
//                    break;
//                }
//            }
//            //将减完的数据添加进去
//            queue.addAll(temp);
//        }
//
//        return res;
    }
}
