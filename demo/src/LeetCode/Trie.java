package LeetCode;

import javax.swing.table.TableRowSorter;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/2 7:04 下午
 * @description 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {
    private final int LENGTH = 26;
    private Trie[] children = new Trie[LENGTH];
    private boolean isEnd = false;

    public Trie() {
    }

    public void insert(String word) {
        Trie trie = this;
        for (char i : word.toCharArray()) {
            if (trie.children[i - 'a'] == null) {
                trie.children[i - 'a'] = new Trie();
            }
            trie=trie.children[i-'a'];
        }
        trie.isEnd=true;
    }

    public boolean search(String word) {
        Trie trie=this;
        for(char i:word.toCharArray()){
            if(trie.children[i-'a']==null){
                return false;
            }
            trie=trie.children[i-'a'];
        }
        return trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie trie=this;
        for(char i:prefix.toCharArray()){
            if(trie.children[i-'a']==null){
                return false;
            }
            trie=trie.children[i-'a'];
        }
        return true;
    }
}