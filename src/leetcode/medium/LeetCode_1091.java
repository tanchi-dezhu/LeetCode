package leetcode.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_1091
{


	// BFS + DP
	int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

	public int shortestPathBinaryMatrix(int[][] grid)
	{
		int n = grid.length;
		if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
		{
			return -1;
		}
		if (n == 1)
		{
			return 1;
		}
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; ++i)
		{
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = 1;
		Deque<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		while (!queue.isEmpty())
		{
			int[] cell = queue.poll();
			int i = cell[0], j = cell[1];
			for (int k = 0; k < dx.length; ++k)
			{
				int x = i + dx[k], y = j + dy[k];
				if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0)
				{
					if (dp[x][y] == Integer.MAX_VALUE)
					{
						queue.offer(new int[]{x, y});
					}
					dp[x][y] = Math.min(dp[x][y], dp[i][j] + 1);
				}
			}
		}
		return dp[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1][n - 1];
	}

	public static void main(String[] args)
	{
		int[][] param = new int[][]{{0,0,0}, {1,1,0}, {1,1,0}};

		LeetCode_1091 a = new LeetCode_1091();
		System.out.println(a.shortestPathBinaryMatrix(param));

	}
}
