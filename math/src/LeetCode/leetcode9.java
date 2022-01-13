package LeetCode;

public class leetcode9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x < 10)) {
            return false;
        }
        int pre = x;
        int curr = 0;
        while (x != 0) {
            curr += curr * 10 + x % 10;
            x /= 10;
        }
        return pre == curr;
    }
}
