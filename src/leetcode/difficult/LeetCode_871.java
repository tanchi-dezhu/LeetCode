package leetcode.difficult;

import java.util.PriorityQueue;

public class LeetCode_871
{
    public static int minRefuelStops(int target, int startFuel, int[][] stations)
    {
        //最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int ans = 0;
        int curGas = startFuel;
        int i = 0;
        while (curGas < target)
        {
            //只要当前油量可以支撑到下一个加油站，就选择不加油
            if (i < stations.length && curGas >= stations[i][0])
            {
                heap.add(stations[i][1]);
                i++;
            } else
            {
                //无法到达，加油
                if (!heap.isEmpty())
                {
                    //堆中有元素 证明路过很多加油站，选择最多油的加油站加油
                    curGas += heap.poll();
                    ans++;
                } else
                {
                    //无元素，证明无法到达
                    return -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[][] stations = new int[][]{{10, 60}, {20, 20}, {30, 100}, {60, 40}};
        System.out.println(minRefuelStops(100, 10, stations));

    }
}
