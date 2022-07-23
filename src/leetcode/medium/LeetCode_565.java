package leetcode.medium;

public class LeetCode_565
{
    public static int arrayNesting(int[] nums)
    {
        int ans = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i)
        {
            int cnt = 0;
            while (!vis[i])
            {
                vis[i] = true;
                i = nums[i];
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args)
    {

        int[] paramList = new int[]{1, 3, 4, 2, 0};
        System.out.println(arrayNesting(paramList));
    }
}
