package leetcode.simple;

import leetcode.bean.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LCP_052
{
	private static Stack<TreeNode> stack = new Stack<>();

	private static Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();

	public static TreeNode increasingBST(TreeNode root)
	{
		bst(root);

		TreeNode result = queue.poll();
		TreeNode tempNode = result;
		while (!queue.isEmpty())
		{
			tempNode.right = queue.poll();
			tempNode = tempNode.right;
		}

		return result;
	}

	public static void bst(TreeNode root)
	{
		if (root == null)
		{
			return;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left != null)
		{
			stack.push(root);
			bst(left);
		}
		else if (right != null)
		{
			queue.add(new TreeNode(root.val));
			bst(right);
		}
		else
		{
			queue.add(new TreeNode(root.val));
		}

		while (!stack.isEmpty())
		{
			TreeNode pop = stack.pop();
			queue.add(new TreeNode(pop.val));
			if (pop.right != null)
			{
				bst(pop.right);
			}
		}
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
