package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:22 下午
 * @description
 */
public class Jian59_2 {
    private int index = 0;
    private List<Integer> deque = null;
    private List<Integer> queue = null;

    public Jian59_2() {
        deque = new ArrayList<>();
        queue = new ArrayList<>();
    }

    public int max_value() {
        if (!deque.isEmpty())
            return deque.get(0);
        return -1;
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && value >= deque.get(deque.size() - 1)) {
            deque.remove(deque.size() - 1);
        }
        deque.add(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int pnum = queue.get(0);
        if (deque.get(0) == pnum)
            deque.remove(0);
        queue.remove(0);
        return pnum;
    }
}
