package leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144
{
    public static class TreeNode
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

    /***
     * 前序遍历核心代码
         while(root != null || !stack.isEmpty()){
         while(root != null){
         res.add(root.val);
         stack.push(root);
         root = root.left;
         }
         TreeNode cur = stack.pop();
         root = cur.right;
         }
     根左右
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty())
        {
            while (root != null)
            {
                result.add(root.val);

                stack.push(root);

                root = root.left;
            }
            root = stack.pop();
            root = root.right;

        }
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode treeNodeL = new TreeNode(2, null, null);
        TreeNode treeNodeR = new TreeNode(3, null, null);

        TreeNode treeNode = new TreeNode(1, treeNodeL, treeNodeR);

        preorderTraversal(treeNode);

    }
}
