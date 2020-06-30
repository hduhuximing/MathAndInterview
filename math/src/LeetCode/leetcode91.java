package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/30 1:32 下午
 */
public class leetcode91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
//        //dp表示长度，有几种编码方式，
//        int dp[] = new int[s.length() + 1];
//        dp[0] = 1;
//        //i表示数组长度，i-1表示当前遍历到位置
//        for (int i = 1; i <= s.length(); i++) {
//            if (s.charAt(i - 1) != '0') {
//                //这里用+和赋值是一样的
//                dp[i] += dp[i - 1];
//            }
//            if (i >= 2) {
//                //    10<cur<26
//                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
//                    dp[i] += dp[i - 2];
//                }
//            }
//        }
//        return dp[s.length()];
        //c2,c1
        //c1表示当前，c2表示前一位
        int c1=1;
        int c2=1;
        for(int i=1;i<s.length();i++){
            int temp=c1;
            if(s.charAt(i)=='0'){
                c1=0;
            }
            //和前一位融合,自身独立以及自身和前面一位合在一起的情况相加
            if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)<='6') {
                c1+=c2;
            }
            c2=temp;
        }
        return c1;
    }
}
