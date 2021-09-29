package 无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-collect
 * @description: 无重复字符的最长子串
 * @author: 52Hz
 * @create: 2021-09-26 11:53
 **/
public class Solution {

    /**
     * 思路：
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                max = Math.max(max, map.size());
                i = map.get(s.charAt(i));
                map = new HashMap<>();
            } else {
                map.put(s.charAt(i), i);
            }
        }
        if (map.size() > max) {
            return map.size();
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
