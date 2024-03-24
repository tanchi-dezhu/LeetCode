package leetcode.simple;

import leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCP_052
{
	public static TreeNode increasingBST(TreeNode root)
	{
		List<Integer> resultList = new ArrayList<>();
		bst(root, resultList);

		TreeNode result = null;
		TreeNode tempNode = null;
		for (int i = 0; i < resultList.size(); i++)
		{
			TreeNode treeNode = new TreeNode(resultList.get(i));

			if (result == null)
			{
				result = treeNode;
				tempNode = result;
			}
			else
			{
				tempNode.right = treeNode;
				tempNode = tempNode.right;

			}
		}
		return result;
	}

	public static void bst(TreeNode root, List<Integer> resultList)
	{
		if (root == null)
		{
			return;
		}

		bst(root.left, resultList);
		resultList.add(root.val);
		bst(root.right, resultList);
	}

	public static void main(String[] args)
	{
		TreeNode treeNode1 = new TreeNode(2, new TreeNode(1), null);
		TreeNode leftChiled = new TreeNode(3, treeNode1, new TreeNode(4));

		TreeNode rightChiled = new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9)));

		TreeNode root = new TreeNode(5, leftChiled, rightChiled);

		TreeNode treeNode = increasingBST(root);
		System.out.println(treeNode);
	}
}
