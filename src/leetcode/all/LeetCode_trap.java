package leetcode.all;

public class LeetCode_trap
{

	public int trap(int[] height)
	{
		if (height == null || height.length == 0)
		{
			return 0;
		}

		int[] leftMax = new int[height.length];
		leftMax[0] = height[0];
		for (int i = 1; i < height.length; i++)
		{
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}

		int[] rightMax = new int[height.length];
		rightMax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--)
		{
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		int ans = 0;
		for (int i = 0; i < height.length; i++)
		{
			ans += Math.min(leftMax[i], rightMax[i]) - height[i];
		}

		return ans;
	}

	public static void main(String[] args)
	{
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		LeetCode_trap obj = new LeetCode_trap();
		int ans = obj.trap(height);
		System.out.println(ans);
	}
}
