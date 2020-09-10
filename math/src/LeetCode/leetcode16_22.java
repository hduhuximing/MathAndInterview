package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/7 12:40 下午
 * @description
 */
public class leetcode16_22 {
    List<String> wordList;
    boolean[] marked;
    List<String> output;
    String endWord;
    List<String> result;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList;
        this.endWord = endWord;
        output = new ArrayList<>();
        marked = new boolean[wordList.size()];
        result = new ArrayList<>();
        dfs(beginWord);
        return result;
    }

    private void dfs(String s) {
        output.add(s);
        Queue<String> queue = help(s);
        for (String curr : queue) {
            if (curr.equals(endWord)) {
                output.add(curr);
                result = new ArrayList<>(output);
                return;
            }
            dfs(curr);
            output.remove(output.size() - 1);
        }
    }

    private Queue<String> help(String s) {
        Queue<String> res = new LinkedList<>();
        for (int i = 0; i < wordList.size(); i++) {
            String s1 = wordList.get(i);
            int diff = 0;
            if (s1.length() != s.length() || marked[i]) {
                continue;
            }
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) != s.charAt(j)) {
                    diff++;
                }
                if (diff >= 2) {
                    break;
                }
            }
            if (diff == 1) {
                res.add(s1);
                marked[i] = true;
            }
        }
        return res;
    }
}
