package offer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        Long res = 0L;
        outer:
        for (int i = start; i <= end; i++) {
            String curr = i + "";
            if (curr.length() == 1) {
                continue;
            }
            inner:
            for (int j = 0; j < curr.length(); j++) {
                StringBuilder str = new StringBuilder();
                for (int k = 0; k < curr.length(); k++) {
                    if (k == j) {
                        continue;
                    }
                    str.append(curr.charAt(k));
                }

                int k = 0;
                while (k != str.length() && str.charAt(k) == '0') {
                    k++;
                }
                if (k == str.length()) {
                    continue inner;
                }


                if (str.length() == 1) {
                    res++;
                    continue outer;
                }
                Long temp = Long.parseLong(str.toString());
                //长度大于1
                if (prime(temp) && plain(temp)) {
                    res++;
                    continue outer;
                }
            }
        }
        System.out.println(res);
    }

    private static boolean plain(Long temp) {
        double sqrt = Math.sqrt(temp);
        if (temp % 2 == 0) {
            return false;
        }
        for (int i = 2; i <= sqrt; i++) {
            if (temp % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean prime(Long temp) {
        StringBuilder str = new StringBuilder();
        str.append(temp);
        String s = str.reverse().toString();
        return s.equals(temp + "");
    }
}
