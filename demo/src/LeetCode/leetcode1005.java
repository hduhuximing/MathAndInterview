package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/6/3 10:13 上午
 * @description
 */
public class leetcode1005 {
    public int findString(String[] words, String s) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int left = 0;
        int right = words.length - 1;
        //相等也是要比较的，没有相等的限制
        while (left <= right) {
            while (left < right && words[left].length() == 0) {
                left++;
            }
            while (left < right && words[right].length() == 0) {
                right--;
            }
            int mid=left+(right-left)/2;
            while(mid<right&&words[mid].length()==0){
                mid++;
            }
            if(words[mid].compareTo(s)>0){
                right=mid-1;
            }else if(words[mid].compareTo(s)<0){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
