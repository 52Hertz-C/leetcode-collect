package 两数之和;

/**
 * @program: leetcode-collect
 * @description: 两数之和
 * @author: 52Hz
 * @create: 2021-09-26 11:53
 **/
public class Solution {

    /**
     * 思路：遍历数组，取出i位置的数值，target与数值相减后的值与从(j=i+1)位置的遍历的数值进行比较，如果相等，返回i和j
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            for (int j = i + 1; j < nums.length; j++) {
                if (b == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
