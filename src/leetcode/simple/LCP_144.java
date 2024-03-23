package leetcode.simple;

import leetcode.bean.TreeNode;

public class LCP_144
{
	public static TreeNode mirrorTree(TreeNode root)
	{
		if (root == null || (root.left == null && root.right == null))
		{
			return root;
		}

		TreeNode temp = new TreeNode();
		temp = root.left;
		root.left = root.right;
		root.right = temp;

		mirrorTree(root.left);
		mirrorTree(root.right);
		return root;
	}

	public static void main(String[] args)
	{
		TreeNode leftChiled = new TreeNode(7, new TreeNode(8), new TreeNode(3));

		TreeNode rightChiled = new TreeNode(9, new TreeNode(2), new TreeNode(4));

		TreeNode root = new TreeNode(5, leftChiled, rightChiled);

		TreeNode treeNode = mirrorTree(root);
		System.out.println(treeNode);
	}
}
