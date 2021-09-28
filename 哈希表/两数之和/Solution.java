package 两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-collect
 * @description: 两数之和
 * @author: 52Hz
 * @create: 2021-09-26 11:53
 **/
public class Solution {

    /**
     * 思路：创建一个哈希表，对于每一个 x，首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
