package leetcode.difficult;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_1036
{
	int[][] blocked;
	int[] source;
	int[] target;
	int MaxPoint;
	int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	Set<Long> blockSet = new HashSet<>();

	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target)
	{
		this.blocked = blocked;
		this.source = source;
		this.target = target;
		this.MaxPoint = (blocked.length + 1) * (blocked.length + 2) / 2;
		// 将block块，放到哈希表，后面遍历地图会用到
		for (int i = 0; i < blocked.length; i++)
			blockSet.add(blocked[i][0] * (long) 1e6 + blocked[i][1]);
		// 分别从起点和终点BFS出发遍历地图
		return bfs(source[0], source[1], true) && bfs(target[0], target[1], false);
	}

	boolean bfs(int x, int y, boolean is_source)
	{
		// vis存放已经访问过的点
		Set<Long> vis = new HashSet<>();
		// 维护BFS过程的队列
		Deque<Long> d = new ArrayDeque<>();
		// 将起点放入队列中，并在vis中标记
		d.add(x * (long) 1e6 + y);
		vis.add(x * (long) 1e6 + y);

		while ((!d.isEmpty()) && (vis.size() <= MaxPoint))
		{
			long p = d.pollFirst();
			long px = (long) (p / 1e6);
			long py = (long) (p - px * 1e6);

			for (int i = 0; i < 4; i++)
			{
				// 找到相邻的点
				long nx = px + dir[i][0];
				long ny = py + dir[i][1];
				// 出边界 或者 是block块
				if (nx < 0 || nx >= 1e6 || ny < 0 || ny >= 1e6 || blockSet.contains(nx * (long) 1e6 + ny))
					continue;
				// 已经访问过
				if (vis.contains(nx * (long) 1e6 + ny))
					continue;
				// 已经找到终点
				if (isArrive(is_source, nx, ny))
					return true;
				// 放入队列中，并在vis中标记
				d.add(nx * (long) 1e6 + ny);
				vis.add(nx * (long) 1e6 + ny);
			}
		}
		// 判断访问过点的数量
		return vis.size() > MaxPoint;
	}

	// 如果从起点出发，那么中途到达终点；
	// 如果从终点出发，那么中途到达起点；
	boolean isArrive(boolean is_source, long x, long y)
	{
		if (is_source && x == target[0] && y == target[1])
			return true;

		if ((!is_source) && x == source[0] && y == source[1])
			return true;

		return false;
	}

	public static void main(String[] args)
	{
		LeetCode_1036 a = new LeetCode_1036();

		int[][] blocked = new int[][]{{0, 1}};
		int[] source = new int[]{0, 0};
		int[] target = new int[]{0, 2};

		System.out.println(a.isEscapePossible(blocked, source, target));
	}
}
