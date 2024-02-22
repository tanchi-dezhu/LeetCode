package leetcode.simple;

public class LeetCode_100
{
	class TreeNode
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

	public boolean isSameTree(TreeNode p, TreeNode q)
	{
		if ((p == null && q != null) || (p != null && q == null))
		{
			return false;
		}

		if (p == q)
		{
			return true;
		}

		if (p.val != q.val)
		{
			return false;
		}

		boolean leftSameTree = isSameTree(p.left, q.left);
		if (!leftSameTree)
		{
			return leftSameTree;
		}

		boolean rightSameTree = isSameTree(p.right, q.right);
		if (!rightSameTree)
		{
			return rightSameTree;
		}

		return true;
	}
}
