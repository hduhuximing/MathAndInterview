package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/7 6:51 下午
 * @description 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。
 * 当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode1306 {
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int len = arr.length;
        boolean[] visit = new boolean[len];
        return help(arr, start, visit);
    }

    private boolean help(int[] arr, int start, boolean[] visit) {
        if (start < 0 || start >= arr.length || visit[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        visit[start] = true;
        return help(arr, start - arr[start], visit) || help(arr, start + arr[start], visit);
    }
}
