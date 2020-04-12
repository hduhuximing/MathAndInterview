package network;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ming
 * @version 1.0
 * @date 2019/11/29 9:51 上午
 * @descirption 判断是否在一个子网络下，用子网掩码进行与运算
 */
public class NetDemo {
    private static boolean isSameSubnet(String s1, String s2) {
        String subNetMask = "255.255.255.0";
        String[] mask = subNetMask.split("\\.");
        String[] ipArr1 = s1.split("\\.");
        String[] ipArr2 = s2.split("\\.");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < mask.length; i++) {
            int v1 = Integer.parseInt(ipArr1[i]) & Integer.parseInt(mask[i]);
            sb1.append(Integer.toBinaryString(v1)).append(" ");
            int v2 = Integer.parseInt(ipArr2[i]) & Integer.parseInt(mask[i]);
            sb2.append(Integer.toBinaryString(v2)).append(" ");
        }
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        return sb1.toString().equals(sb2.toString());
    }

    public int sumFourDivisors(int[] nums) {
        int count = 0;
        outer:
        for (int j = 0; j < nums.length; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <=(int) Math.sqrt(nums[j]); i++) {
                if (nums[j] % i == 0) {
                    set.add(i);
                    set.add(nums[j] / i);
                    if (set.size() > 4) {
                        continue outer;
                    }
                }
            }
            if (set.size() == 4) {
                for (int cur : set) {
                    count += cur;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String ip1 = "192.168.1.3";
        String ip2 = "192.168.1.4";
        boolean sameSubnet = isSameSubnet(ip1, ip2);
        System.out.println(sameSubnet);
    }
}
