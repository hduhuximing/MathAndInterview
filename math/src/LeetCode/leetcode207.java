package LeetCode;

import java.util.LinkedList;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/1 11:42 上午
 * @description
 */
public class leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegress[prerequisite[0]]++;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < indegress.length; i++) {
            if (indegress[i] == 0) {
                list.add(i);
            }
        }
        while (!list.isEmpty()) {
            Integer pop = list.pop();
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == pop) {
                    if (--indegress[indegress[pop]] == 0) {
                        list.add(indegress[pop]);
                    }
                }
            }
        }
        return numCourses == 0;
    }

}
