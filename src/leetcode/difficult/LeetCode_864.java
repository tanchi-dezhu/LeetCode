package leetcode.difficult;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_864
{

	// 控制人物可以移动的方向
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public int shortestPathAllKeys(String[] grid)
	{
		int n = grid.length;
		int m = grid[0].length();
		int keyNum = 0; // 钥匙数量
		List<int[]> list = new LinkedList<>();
		// 初始化地图信息
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				char c = grid[i].charAt(j);
				if (c == '@')
				{ // 起点
					list.add(new int[]{i, j, 0});
				}
				if ('a' <= c && c <= 'z')
				{ // 钥匙
					keyNum += 1;
				}
			}
		}
		// 在每一个区域，收集到（不同数目不同类别）的钥匙，所需的步长
		int[][][] dist = new int[n][m][1 << keyNum];
		// 从地图起点，往各个反向寻找钥匙
		while (list.size() != 0)
		{
			int[] arr = list.remove(0);
			int x = arr[0]; // x 坐标
			int y = arr[1]; // y 坐标
			int s = arr[2]; // 物品状态
			int step = dist[x][y][s];
			for (int[] dir : dirs)
			{
				int xx = x + dir[0];
				int yy = y + dir[1];
				int ss = s;
				if (xx < 0 || n <= xx || yy < 0 || m <= yy)
				{
					continue; // 不允许走出地图边界
				}
				char c = grid[xx].charAt(yy);
				if (c == '#')
				{
					continue; // 不允许走到墙里
				}
				if ('A' <= c && c <= 'Z')
				{ // 遇到锁
					if ((s >> (c - 'A') & 1) != 1)
					{
						continue; // 没有对应锁的钥匙，不允许通过
					}
				}
				if ('a' <= c && c <= 'z')
				{ // 遇到钥匙
					ss |= 1 << (c - 'a'); // 把钥匙捡起来放入物品箱
				}
				if (ss == (1 << keyNum) - 1)
				{
					return step + 1; // 每把钥匙都收集到了
				}
				// 如果该地没走过，或者走到此处比曾经用过的步数更少
				if (dist[xx][yy][ss] == 0 || step + 1 < dist[xx][yy][ss])
				{
					dist[xx][yy][ss] = step + 1; // 更新最小步数
					list.add(new int[]{xx, yy, ss}); // 记录状态
				}
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		String[] param = new String[]{"@.a.#", "###.#", "b.A.B"};

		LeetCode_864 aa = new LeetCode_864();

		System.out.println(aa.shortestPathAllKeys(param));
	}
}
