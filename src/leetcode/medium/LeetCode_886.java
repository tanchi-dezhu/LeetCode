package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode_886
{

    public static boolean possibleBipartition(int n, int[][] dislikes)
    {

        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; ++i)
        {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] p : dislikes)
        {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i)
        {
            if (color[i] == 0)
            {
                Queue<Integer> queue = new ArrayDeque<Integer>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty())
                {
                    int t = queue.poll();
                    for (int next : g[t])
                    {
                        if (color[next] > 0 && color[next] == color[t])
                        {
                            return false;
                        }
                        if (color[next] == 0)
                        {
                            color[next] = 3 ^ color[t];
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {

        int[][] array = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};

        System.out.println(possibleBipartition(5, array));
    }
}