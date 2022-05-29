package leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94
{
    /** 中序排序核心代码
     * while (root != null || !stack.isEmpty()) {
     *     while (root != null) {
     *         stack.push(root);
     *         root = root.left;
     *     }
     *     root = stack.pop();
     *     res.add(root.val);
     *     root = root.right;
     * }
     * 左根右
     * @param root
     * @return
     */

    public List<Integer> inorderTraversal(TreeNode root)
    {
        Stack<TreeNode> stack =new Stack();

        List<Integer> result = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }

    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode()
        {
        }

        TreeNode(int val)
        {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
