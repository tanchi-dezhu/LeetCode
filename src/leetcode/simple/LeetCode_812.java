package leetcode.simple;

public class LeetCode_812
{
    public static double largestTriangleArea(int[][] points)
    {
        int n = points.length;
        double ret = 0.0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    ret = Math.max(ret, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return ret;
    }

    /***
     * 根据三个点获取三角形面积
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @return
     */
    public static double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3)
    {
//        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
        return 0.5 * Math.abs((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)));
    }

    public static void main(String[] args)
    {
        int[][] arrays = new int[][]{{4, 6}, {6, 5}, {3, 1}};
        System.out.println(largestTriangleArea(arrays));
    }
}
