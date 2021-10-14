## [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

给定一个二叉树的根节点 root ，返回它的 中序 遍历。


示例1:

![img.png](img.png)
```
输入：root = [1,null,2,3]
输出：[1,3,2]
```

示例 2:
```
输入：root = []
输出：[]
```

示例 3:
```
输入：root = [1]
输出：[1]
```

示例 4:

![img_1.png](img_1.png)
```
输入：root = [1,2]
输出：[2,1]
```

示例 5:

![img_2.png](img_2.png)
```
输入：root = [1,null,2]
输出：[1,2]
```


**提示：** 

* 树中节点数目在范围 [0, 100] 内
* -100 <= Node.val <= 100