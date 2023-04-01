package leetcode.difficult;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LeetCode_1293
{

	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public int shortestPath(int[][] grid, int k)
	{
		int m = grid.length, n = grid[0].length;
		if (k >= m + n - 3)
		{
			return m + n - 2;
		}
		int[][][] distances = new int[m][n][k + 1];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				Arrays.fill(distances[i][j], Integer.MAX_VALUE);
			}
		}
		distances[0][0][0] = 0;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[]{0, 0, 0});
		while (!queue.isEmpty())
		{
			int[] state = queue.poll();
			int row = state[0], col = state[1], eliminations = state[2];
			int distance = distances[row][col][eliminations];
			if (row == m - 1 && col == n - 1)
			{
				return distance;
			}
			for (int[] dir : dirs)
			{
				int newRow = row + dir[0], newCol = col + dir[1];
				if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
				{
					if (grid[newRow][newCol] == 0)
					{
						if (distances[newRow][newCol][eliminations] == Integer.MAX_VALUE)
						{
							distances[newRow][newCol][eliminations] = distance + 1;
							queue.offer(new int[]{newRow, newCol, eliminations});
						}
					} else
					{
						if (eliminations < k && distances[newRow][newCol][eliminations + 1] == Integer.MAX_VALUE)
						{
							distances[newRow][newCol][eliminations + 1] = distance + 1;
							queue.offer(new int[]{newRow, newCol, eliminations + 1});
						}
					}
				}
			}
		}
		return -1;
	}


	public static void main(String[] args)
	{
		LeetCode_1293 a = new LeetCode_1293();


		int[][] param = new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};

		System.out.println(a.shortestPath(param, 0));

	}
}
