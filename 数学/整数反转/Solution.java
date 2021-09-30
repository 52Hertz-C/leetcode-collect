package 整数反转;

/**
 * @program: leetcode-collect
 * @description: 整数反转
 * @author: 52Hz
 * @create: 2021-09-30 10:36
 **/
public class Solution {

    /**
     * 思路：转成String，遍历String反转后转成int
     *
     * @param nums
     * @param target
     * @return
     */
    public int reverse(int x) {
        String res = (x >= 0 ? "" : "-");
        String str = String.valueOf(x);
        for (int i = str.length() - 1; i >= (x >= 0 ? 0 : 1); i--) {
            res += str.charAt(i);
        }
        int resInt = 0;
        try {
            resInt = Integer.parseInt(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resInt;
    }

    /**
     * 思路：用取模运算拿到这个整数的末尾数字。以12345为例，先拿到5，再拿到4，之后是3，2，1，按这样的顺序就可以反向拼接处一个数字了，也就能达到 反转 的效果。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int remainder = x % 10;
            res = res * 10 + remainder;
            x = x / 10;
        }
        return res;
    }
}
