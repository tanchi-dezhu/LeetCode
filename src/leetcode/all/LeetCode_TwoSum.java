package leetcode.all;

import java.util.HashMap;

public class LeetCode_TwoSum
{

	public int[] twoSum(int[] nums, int target)
	{
		HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++)
		{
			int complement = target - nums[i];
			if (tempMap.containsKey(complement))
			{
				return new int[]{tempMap.get(complement), i};
			}

			tempMap.put(nums[i], i);
		}

		return null;
	}

	public static void main(String[] args)
	{

	}
}
