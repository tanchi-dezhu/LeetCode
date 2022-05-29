package leetcode.simple;

import java.util.*;

public class LeetCode_145
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
     * 后序遍历核心代码
     *  while(root != null || !stack.isEmpty()){
     *         while(root != null){
     *             res.add(root.val);
     *             stack.push(root);
     *             root = root.right;
     *         }
     *
     *         TreeNode cur = stack.pop();
     *       	root = cur.left;
     *     }
     *     左右根（根右左的反转之后就是左右根）
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> result  = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                result.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args)
    {
        TreeNode treeNodeL = new TreeNode(2, null, null);
        TreeNode treeNodeR = new TreeNode(3, null, null);

        TreeNode treeNode = new TreeNode(1, treeNodeL, treeNodeR);
        postorderTraversal(treeNode);
    }
}
