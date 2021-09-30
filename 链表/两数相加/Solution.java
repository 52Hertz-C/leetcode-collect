package 两数相加;

/**
 * @program: leetcode-collect
 * @description: 两数相加
 * @author: 52Hz
 * @create: 2021-09-29 17:53
 **/
public class Solution {

    /**
     * 思路：同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。数据存入数组，最后转成链表
     *
     * @param nums
     * @param target
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        boolean valBol = false;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode tmpNode1 = l1.next;
        ListNode tmpNode2 = l2.next;
        int val = l1.val + l2.val;
        if (val >= 10) {
            valBol = true;
            val %= 10;
        }
        list.add(val);
        while (tmpNode1 != null && tmpNode2 != null) {
            int tmpVal = tmpNode1.val + tmpNode2.val;
            valBol = addList(list, tmpVal, valBol);
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
        }
        valBol = addLeftList(tmpNode1, list, valBol);
        valBol = addLeftList(tmpNode2, list, valBol);
        if (valBol) {
            list.add(1);
        }
        return changeArrayToNode2(list);
    }

    private static boolean addLeftList(ListNode tmpNode1, List<Integer> list, boolean valBol) {
        if (tmpNode1 != null) {
            while (tmpNode1 != null) {
                int tmp = tmpNode1.val;
                valBol = addList(list, tmp, valBol);
                tmpNode1 = tmpNode1.next;
            }
        }
        return valBol;
    }

    private static boolean addList(List<Integer> list, int tmp, boolean valBol) {
        if (valBol) {
            tmp++;
            valBol = false;
        }
        if (tmp >= 10) {
            tmp -= 10;
            valBol = true;
        }
        list.add(tmp);
        return valBol;
    }

    public static ListNode changeArrayToNode2(List<Integer> arr) {
        if(arr == null || arr.size() <= 0){return null;}

        ListNode sentineNode = new ListNode(0);  //建立哨兵节点
        ListNode tempNode = sentineNode;  //tempNode变量指向哨兵节点
        for(int i = 0; i < arr.size(); i++) {
            ListNode newNode = new ListNode(arr.get(i));
            tempNode.next = newNode;    //临时节点‘后继指针’指向新节点
            tempNode = newNode;        //把新节点赋给临时变量tempNode
        }
        return sentineNode.next;
    }

    /**
     * 思路：同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。直接转换成链表
     *
     * @param nums
     * @param target
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        boolean valBol = false;

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode tmpNode1 = l1.next;
        ListNode tmpNode2 = l2.next;
        int val = l1.val + l2.val;
        if (val >= 10) {
            valBol = true;
            val %= 10;
        }

        ListNode sentinelNode = new ListNode(val);
        ListNode tempNode = sentinelNode;
        ListNode newNode;
        while (tmpNode1 != null && tmpNode2 != null) {
            int tmpVal = tmpNode1.val + tmpNode2.val;
            if (valBol) {
                tmpVal++;
                valBol = false;
            }
            if (tmpVal >= 10) {
                tmpVal %= 10;
                valBol = true;
            }
            newNode = new ListNode(tmpVal);
            tempNode.next = newNode;
            tempNode = newNode;
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
        }
        if (tmpNode1 != null) {
            while (tmpNode1 != null) {
                int tmp = tmpNode1.val;

                if (valBol) {
                    tmp++;
                    valBol = false;
                }
                if (tmp >= 10) {
                    tmp -= 10;
                    valBol = true;
                }
                newNode = new ListNode(tmp);
                tempNode.next = newNode;
                tempNode = newNode;

                tmpNode1 = tmpNode1.next;
            }
        }
        if (tmpNode2 != null) {
            while (tmpNode2 != null) {
                int tmp = tmpNode2.val;
                if (valBol) {
                    tmp++;
                    valBol = false;
                }
                if (tmp >= 10) {
                    tmp -= 10;
                    valBol = true;
                }
                newNode = new ListNode(tmp);
                tempNode.next = newNode;
                tempNode = newNode;
                tmpNode2 = tmpNode2.next;
            }
        }
        if (valBol) {
            newNode = new ListNode(1);
            tempNode.next = newNode;
            tempNode = newNode;
        }
        return sentinelNode;
    }
}

class ListNode {

    public int val;

    public ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
