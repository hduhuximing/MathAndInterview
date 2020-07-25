package offer;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import lombok.Data;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/1 10:11 下午
 * @description 在一个int数组里查找这样的数，它大于等于左侧所有数，小于等于右侧所有数
 */
@Data
class Man {
    String name;
    int age;

}

public class mianshi {

    public static int findNum(int[] arr, int n) {
        if (arr == null) {
            return 0;
        }
        int res[] = new int[n];
        int index = 0;
        res[index++] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                res[index++] = arr[i];
            } else {
                while (index > 0 && res[index - 1] > arr[i]) {
                    index--;
                }
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(res[i]);
        }
        return index;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 2, 4, 5, 6, 7, 8, 9, 10, 3, 11};
//        int count = findNum(arr, 11);
//        System.out.println("count:" + count);
//
//        HashMap<Integer, Man> map = new HashMap<>();
//        Man p = new Man();
//
//        p.setName("zhangsan");
//        p.setAge(11);
//        map.put(1, p);
//        map.values().forEach((value)->{
//            value.setName("nihao");
//        });
//
//        map.forEach((key,value) -> System.out.println(key+"<------------>"+value));
//
//
//        List<Man> collect = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

        String content = "test中文--testteeq";

//随机生成密钥
        //长度限制为15
        byte[] keys = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        System.out.println(Arrays.toString(keys));
        byte[] key = "abcdedfhijklmnop".getBytes();
        byte[] key1= "abcdedfhijkl mnop".getBytes();

//构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        SymmetricCrypto res = new SymmetricCrypto(SymmetricAlgorithm.AES, key1);

////加密
//        byte[] encrypt = aes.encrypt(content);
////解密
//        byte[] decrypt = res.decrypt(encrypt);

//加密为16进制表示
        String encryptHex = aes.encryptHex(content);
//解密为字符串
        try{
        String decryptStr = res.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("解析失败");
        }
    }

}