package LeetCode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/5/15 2:13 下午
 * @description
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class leetcode690 {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        LinkedList<Employee> temp = new LinkedList<>();
        temp.add(map.get(id));
        int res = 0;
        while (!temp.isEmpty()) {
            Employee employee = temp.removeFirst();
            res += employee.importance;
            for (int sub : employee.subordinates) {
                temp.add(map.get(sub));
            }
        }
        return res;
    }
}
