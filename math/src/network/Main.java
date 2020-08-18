package network;


import java.util.HashSet;

public class Main {

    boolean res = false;

    public boolean Game24Points(int[] arr) {
        help(arr, 24, new HashSet<>());
        return res;
    }

    private boolean help(int[] arr, double num, HashSet<Integer> path) {
        if (num == 0) {
            res = true;
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (path.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (path.contains(j)) {
                    continue;
                }
                path.add(i);
                path.add(j);
                if (help(arr, num - (arr[i] + arr[j]), path))
                    return true;
                else if (help(arr, num / (arr[i] + arr[j]), path))
                    return true;

                else if (help(arr, num - (arr[i] - arr[j]), path))
                    return true;
                else if (help(arr, num / (arr[i] - arr[j]), path))
                    return true;

                else if (help(arr, num - (arr[i] * arr[j]), path))
                    return true;
                else if (help(arr, num / (arr[i] * arr[j]), path))
                    return true;

                else if (help(arr, num - (arr[i] / arr[j]), path))
                    return true;
                else if (help(arr, num / (arr[i] / arr[j]), path))
                    return true;
                path.remove(i);
                path.remove(j);
            }
        }
        return false;

    }
}