package leetcode.medium;

import java.time.LocalTime;
import java.util.Arrays;

public class LeetCode_377
{
	public static int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int num : nums) {
				if (num > i) {
					break;
				}
				dp[i] += dp[i - num];
			}
		}
		return dp[target];
	}

	public static void main(String[] args)
	{
		int[] param = new int[]{1, 2, 3};

		System.out.println(LocalTime.now());

		System.out.println(combinationSum4(param, 4));

		System.out.println(LocalTime.now());

	}
}
