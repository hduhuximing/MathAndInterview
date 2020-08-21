package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/21 2:16 下午
 * @description
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
//String str2 = "BBC";
        int[] next = kmpNext("ABCDABD");
        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15 了
    }

    private static int kmpSearch(String s1, String s2, int[] next) {
        int i = 0;
        int j = 0;
        while (i < s1.length()) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i - j + 1;
            }
            i++;
        }
        return 0;
    }

    private static int[] kmpNext(String s) {
        int[] next = new int[s.length()];
        int i = 1;
        int j = 0;
        while (i < s.length()) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
            i++;
        }
        return next;
    }
}

