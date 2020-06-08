package offer;


import java.util.HashMap;

public class Main {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (int curr : map.values()) {
            if (curr % 2 != 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}




