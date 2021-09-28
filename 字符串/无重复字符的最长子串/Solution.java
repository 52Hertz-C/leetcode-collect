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
     * 暴力解法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet set = new HashSet();
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int temp = 1;
        for (int i = 0; i < len; i++) {
            set.clear();
            char a = s.charAt(i);
            set.add(a);
            for (int j = i + 1; j < len; j++) {
                char b = s.charAt(j);
                boolean add = set.add(b);
                if (!add) {
                    if (j - i >= temp) {
                        temp = j - i;
                    }
                    break;
                }
                if (j == len - 1) {
                    if (j - i >= temp) {
                        temp = j - i + 1;
                    }
                }
            }
        }
        return temp;
    }
}
