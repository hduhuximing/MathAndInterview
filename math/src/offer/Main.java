package offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 35 27 47 68 84
 * 15 20 21 25 27 35 47 68 84
 * 15 20 21 25 27 35 47 68 84
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        quickSort(num, 0, N - 1);
        System.out.println(Arrays.toString(num));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int stard = arr[start];
            int low = start;
            int high = end;
            while (low < high) {//相等跳出
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;

            quickSort(arr, start, low - 1);
            System.out.println(Arrays.toString(arr));

            quickSort(arr, low + 1, end);
            System.out.println(Arrays.toString(arr));

        }else {

        }
    }
}

//        Scanner sc = new Scanner(System.in);
//        int[] num = new int[5];
//        for (int i = 0; i < 5; i++) {
//            num[i] = sc.nextInt();
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, num[0]);
//        map.put(5, num[1]);
//        map.put(10, num[2]);
//        map.put(50, num[3]);
//        map.put(100, num[4]);
//        int aim = sc.nextInt();
//        long res = 0;
//
//        Integer num100 = map.get(100);
//        while (aim > 0) {
//            if (aim >= 100 && num100 > 0) {
//                aim -= 100;
//                num100--;
//                res++;
//            } else {
//                break;
//            }
//        }
//
//        Integer num50 = map.get(100);
//        while (aim > 0) {
//            if (aim >=50 && num50 > 0) {
//                aim -= 50;
//                num50--;
//                res++;
//            } else {
//                break;
//            }
//        }
//
//        Integer num10 = map.get(100);
//        while (aim > 0) {
//            if (aim >= 10 && num10 > 0) {
//                aim -= 10;
//                num10--;
//                res++;
//            } else {
//                break;
//            }
//        }
//
//        Integer num5 = map.get(100);
//        while (aim > 0) {
//            if (aim >= 5 && num5 > 0) {
//                aim -= 5;
//                num5--;
//                res++;
//            } else {
//                break;
//            }
//        }
//        Integer num1 = map.get(100);
//        while (aim > 0) {
//            if (aim >= 1 && num1 > 0) {
//                aim -= 1;
//                num5--;
//                res++;
//            } else {
//                break;
//            }
//        }
//        if (aim != 0) {
//            System.out.println(-1);
//        } else {
//            System.out.println(res);
//        }
//    }
//}




