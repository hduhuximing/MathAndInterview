package LeetCode;


/**
 * @author ming
 * @version 1.0
 * @date 2020/5/22 1:05 下午
 * @description 你正在使用一堆木板建造跳水板。有两种类型的木板，
 * 其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 */
public class leetcode16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            int[] result = new int[1];
            result[0] = k * shorter;
            return result;
        }
        int result[] = new int[k + 1];
        //循环把可能的结果往数组里面塞
        for (int i = 0; i <= k; i++) {
            result[i] = (k - i) * shorter + i * longer;
        }
        return result;
    }

    /**
     * ip转化为16进制
     * @param strIp
     * @return
     */
    public static int ipToLong(String strIp) {
//        if (String..isBlank(strIp)) {
//            return 0;
//        }
        String[] ipArr = strIp.split("\\.");
        if (ipArr.length != 4) {
            return 0;
        }
        int[] ip = new int[4];
        // 先找到IP地址字符串中.的位置
        // 将每个.之间的字符串转换成整型
        ip[0] = Integer.parseInt(ipArr[0]);
        ip[1] = Integer.parseInt(ipArr[1]);
        ip[2] = Integer.parseInt(ipArr[2]);
        ip[3] = Integer.parseInt(ipArr[3]);
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    public static void main(String[] args) {
        System.out.println(Integer.toHexString(ipToLong("1.1.1.1")));
    }

}
