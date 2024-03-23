package leetcode.simple;

import leetcode.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_1022
{

    public static int sumRootToLeaf(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        int val = 0, ret = 0;
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                val = (val << 1) | root.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == prev) {
                if (root.left == null && root.right == null) {
                    ret += val;
                }
                val >>= 1;
                stack.pop();
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return ret;
    }

    public static void main(String[] args)
    {

        TreeNode treeNodeL = new TreeNode(1, null, null);
        TreeNode treeNodeR = new TreeNode(0, null, null);

        TreeNode treeNode = new TreeNode(1, treeNodeL, treeNodeR);
        System.out.println(sumRootToLeaf(treeNode));
    }
}
